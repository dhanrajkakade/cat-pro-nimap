package com.springboot.app.service;

import com.springboot.app.entity.Product;
import com.springboot.app.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ProductService {
	
	Page<Product> getAllproducts(Pageable pageable);
	public Product setProduct(Product p);
	public Product getProductById(int id) throws ProductNotFoundException;
	public Product upadteProductById(Product p, int id) throws ProductNotFoundException;
	public void deleteProductById(int id)throws ProductNotFoundException;
	
}
