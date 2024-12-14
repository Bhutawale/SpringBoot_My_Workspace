package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	
	public ResponseEntity<?> handleEmployeeNotFound(EmployeeNotFoundException e)
	{
		
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}
