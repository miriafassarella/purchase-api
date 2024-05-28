package com.purchase.api.domain.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.purchase.api.domain.model.Product;
import com.purchase.api.domain.repository.ProductRepository;





@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	public Product searchProduct(Long productId) {
		Optional<Product> productCurrent = productRepository.findById(productId);
		return productCurrent.get();
	}
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	public void removeProduct(Long productId) {
		Optional<Product> productCurrent = productRepository.findById(productId);
		productRepository.delete(productCurrent.get());
		
	}
	public Product updateProduct(Product product, Long productId) {
		Optional<Product> productCurrent = productRepository.findById(productId);
		BeanUtils.copyProperties(product, productCurrent.get(), "id"); 
			  
		return productRepository.save(productCurrent.get());
			
	}
}
