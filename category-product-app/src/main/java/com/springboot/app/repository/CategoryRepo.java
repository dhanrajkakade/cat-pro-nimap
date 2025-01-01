package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}
