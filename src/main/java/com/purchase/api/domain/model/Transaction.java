package com.purchase.api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Transaction {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDate dateRegister = LocalDate.now();
	
	private String description;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "id_school")
	private School school;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product = new Product();
	
	private int amountProduct;
	private BigDecimal priceFinal;
	
	
	
	
	
}
