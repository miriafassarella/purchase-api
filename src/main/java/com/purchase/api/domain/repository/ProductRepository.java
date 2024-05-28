package com.purchase.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purchase.api.domain.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
