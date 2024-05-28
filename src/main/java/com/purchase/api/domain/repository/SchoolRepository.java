package com.purchase.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purchase.api.domain.model.School;


public interface SchoolRepository extends JpaRepository<School, Long>{

}
