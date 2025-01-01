package com.springboot.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.app.entity.Category;
import com.springboot.app.exception.CategoryNotFoundException;
import com.springboot.app.repository.CategoryRepo;
import com.springboot.app.service.CategoryService;

@Service
public class CatServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo catr;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
        return catr.findAll(pageable);
	}
	
	@Override
	public Category newCat(Category c) {
		return catr.save(c);
	}

	@Override
	public Category getCatById(int id) throws CategoryNotFoundException {
		return catr.findById(id).orElseThrow(()-> new CategoryNotFoundException("Entered Category ID doesn't exists"));
	}

	@Override
	public Category updateCatById(Category c, int cid) throws CategoryNotFoundException {
		Category newcat = catr.findById(cid).orElseThrow(()-> new CategoryNotFoundException("Entered Category ID doesn't exists"));
	
		newcat.setCname(c.getCname());
		
				catr.save(newcat);
				return newcat;
	}

	@Override
	public void deleteCatById(int cid) throws CategoryNotFoundException {
		catr.findById(cid).orElseThrow(()-> new CategoryNotFoundException("Entered Category Id Does't Exists"));
		catr.deleteById(cid);	
	}

}


	


