package com.purchase.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purchase.api.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
