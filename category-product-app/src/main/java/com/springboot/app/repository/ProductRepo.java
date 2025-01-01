package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.app.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{    
    

}
