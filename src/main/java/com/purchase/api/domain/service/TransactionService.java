package com.purchase.api.domain.service;


import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.purchase.api.domain.model.Transaction;

import com.purchase.api.domain.repository.TransactionRepository;




@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
		
	public Transaction searchTransaction(Long transactionId) {
		Optional<Transaction> transactionCurrent = transactionRepository.findById(transactionId);
		return transactionCurrent.get();
		
	}
	public Transaction addTransaction(Transaction transaction) {
		
		transaction.setPriceFinal((transaction.getPrice().multiply(BigDecimal.valueOf(transaction.getAmountProduct()))));
		
		return transactionRepository.save(transaction);
	}
	public void removeTransaction(Long transactionId) {
		Optional<Transaction> transactionCurrent = transactionRepository.findById(transactionId);
		transactionRepository.delete(transactionCurrent.get());
		
	}
	public Transaction updateTransaction(Transaction transaction, Long transactionId) {
		Optional<Transaction> transactionCurrent = transactionRepository.findById(transactionId);
		
		transaction.setPriceFinal(transaction.getPrice().multiply(BigDecimal.valueOf(transaction.getAmountProduct())));
		BeanUtils.copyProperties(transaction, transactionCurrent.get(), "id"); 
		return transactionRepository.save(transactionCurrent.get());
	}
}
