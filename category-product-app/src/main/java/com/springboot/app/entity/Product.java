package com.springboot.app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "products")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(length = 50, nullable=false)
	@NotBlank(message = "Product Can't be Blank")
	private String pname;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "cid", nullable = false)
//    @JsonManagedReference 
    private Category category;
}
