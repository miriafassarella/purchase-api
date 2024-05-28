package com.purchase.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.api.domain.model.Transaction;
import com.purchase.api.domain.repository.TransactionRepository;
import com.purchase.api.domain.service.TransactionService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	public TransactionService transactionService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping
	public Page<Transaction> listTransaction(Pageable pageable){
		Page<Transaction> transaction =  transactionRepository.findAll(pageable);
		List<Transaction> transactionPage =  transaction.getContent();
		
		Page<Transaction> pageImpl = new PageImpl<>(transactionPage, pageable, transaction.getTotalElements());
		
		return pageImpl;
	}
	
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> searchTransaction(@PathVariable Long transactionId){
		
		Transaction transactionCurrent = transactionService.searchTransaction(transactionId);
		return ResponseEntity.status(HttpStatus.OK).body(transactionCurrent);
		
	}
	@PostMapping
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
		
		Transaction transactionSave = transactionService.addTransaction(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionSave);
	}
	@DeleteMapping("/{transactionId}")
	public ResponseEntity<Transaction> removeTransaction(@PathVariable Long transactionId){

		transactionService.removeTransaction(transactionId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@PutMapping("/{transactionId}")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable Long transactionId){
		Transaction transactionSave  = transactionService.updateTransaction(transaction, transactionId);
		return ResponseEntity.status(HttpStatus.OK).body(transactionSave);
	}
}
