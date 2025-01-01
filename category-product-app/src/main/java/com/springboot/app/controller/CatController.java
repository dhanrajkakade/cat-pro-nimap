package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.springboot.app.entity.Category;
import com.springboot.app.exception.CategoryNotFoundException;
import com.springboot.app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/categories")
public class CatController {
	
	@Autowired
	CategoryService cs;
	
	@GetMapping
    public ResponseEntity<Page<Category>> getAllCat(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(cs.getAllCategories(pageable), HttpStatusCode.valueOf(200));
    }
	
	@PostMapping("/savecat")
	public ResponseEntity<Category> newCat(@Valid @RequestBody Category c){
		return new ResponseEntity<Category>(cs.newCat(c),HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> GetCatById(@PathVariable("id") int id) throws CategoryNotFoundException {
	    return new ResponseEntity<>(cs.getCatById(id), HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<Category> updateCatById(@PathVariable("cid") int cid,@RequestBody Category c) throws CategoryNotFoundException{
		return new ResponseEntity<Category>(cs.updateCatById(c,cid),HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<String> deleteCatById(@PathVariable("cid") int cid) throws CategoryNotFoundException {
	    cs.deleteCatById(cid);
	    return new ResponseEntity<>("Deleted Successfully", HttpStatusCode.valueOf(200));
	}
	
}
