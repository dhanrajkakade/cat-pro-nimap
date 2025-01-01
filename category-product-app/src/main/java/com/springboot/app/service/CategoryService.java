package com.springboot.app.service;
import com.springboot.app.entity.Category;
import com.springboot.app.exception.CategoryNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
	

    Page<Category> getAllCategories(Pageable pageable);
	public Category newCat(Category c);
	public Category getCatById(int id) throws CategoryNotFoundException;
	public Category updateCatById(Category c, int id) throws CategoryNotFoundException;
	public void deleteCatById(int id) throws CategoryNotFoundException;
	
}


