package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.entity.Product;
import com.springboot.app.exception.ProductNotFoundException;
import com.springboot.app.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProController {
	
	@Autowired
	ProductService ps;
	
	@GetMapping
	public ResponseEntity<Page<Product>> getAllproducts(
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "10")int size){
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(ps.getAllproducts(pageable),HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/saveprod")
	public ResponseEntity<Product> setProduct(@Valid @RequestBody Product p){
		return new ResponseEntity<Product>(ps.setProduct(p),HttpStatusCode.valueOf(201));
	}


	@GetMapping("/{id}")
	public ResponseEntity<Product> GetProductById(@PathVariable("id") int id) throws ProductNotFoundException {
	    return new ResponseEntity<>(ps.getProductById(id), HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Product> updateProById(@PathVariable("pid") int pid, @RequestBody Product p) throws ProductNotFoundException{
		return new ResponseEntity<Product>(ps.upadteProductById(p, pid), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<String> deleteProById(@PathVariable("pid") int pid) throws ProductNotFoundException {
		ps.deleteProductById(pid);
		return new ResponseEntity<>("Deleted Successfully", HttpStatusCode.valueOf(200));
	}
			
}
