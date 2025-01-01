package com.springboot.app.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.app.entity.Product;
import com.springboot.app.exception.ProductNotFoundException;
import com.springboot.app.repository.ProductRepo;
import com.springboot.app.service.ProductService;

@Service
public class ProServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo prepo;

	@Override
	public Page<Product> getAllproducts(Pageable pageable) {
		return prepo.findAll(pageable);
	}
	
	@Override
	public Product setProduct(Product p) {
	    System.out.println("Saving Product: " + p);
	    return prepo.save(p);
	}


	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
		return prepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Entered Product ID doesn't exists"));
	}

	@Override
	public Product upadteProductById(Product p, int pid) throws ProductNotFoundException {
		Product newpro = prepo.findById(pid).orElseThrow(()-> new ProductNotFoundException("Entered Product ID doesn't exists"));
	
		newpro.setPname(p.getPname());
		newpro.setPrice(p.getPrice());
		
		prepo.save(newpro);
		return newpro;
	}

	@Override
	public void deleteProductById(int pid) throws ProductNotFoundException {
		prepo.findById(pid).orElseThrow(()-> new ProductNotFoundException("Entered Product ID doesn't exists"));
		prepo.deleteById(pid);
	}
	
}
