package com.purchase.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.purchase.api.domain.model.Product;
import com.purchase.api.domain.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> listProducts(){
		return productService.listProducts();
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> searchProduct(@PathVariable Long productId){
		Product productCurrent = productService.searchProduct(productId);
		return ResponseEntity.status(HttpStatus.FOUND).body(productCurrent);
		
	}
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product productSave = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
	}
	@DeleteMapping("/{productId}")
	public ResponseEntity<Product> removeProduct(@PathVariable Long productId){
		productService.removeProduct(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productId){
		Product productSave  = productService.updateProduct(product, productId);
		return ResponseEntity.status(HttpStatus.OK).body(productSave);
		
	}
}
