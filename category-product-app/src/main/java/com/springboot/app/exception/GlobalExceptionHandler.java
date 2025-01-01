package com.springboot.app.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorMessage>handleCategoryNotFoundException
	(CategoryNotFoundException e,WebRequest request){
		
		ErrorMessage em=new ErrorMessage(HttpStatusCode.valueOf(404),e.getMessage());
		return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(em);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage>handleProductNotFoundException
	(ProductNotFoundException e,WebRequest request) {
		
		ErrorMessage em=new ErrorMessage(HttpStatusCode.valueOf(404),e.getMessage());
		return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(em);
	}

}
