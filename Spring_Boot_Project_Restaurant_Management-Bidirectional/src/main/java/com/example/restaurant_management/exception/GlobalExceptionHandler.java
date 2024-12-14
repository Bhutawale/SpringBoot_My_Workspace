package com.example.restaurant_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<?> handleAdminNotFound(AdminNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
}
