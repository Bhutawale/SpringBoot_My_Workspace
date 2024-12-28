package com.revision.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler
								(StudentNotFoundException studentNotFoundException)
	{
		String message=studentNotFoundException.getMessage();
		ExceptionResponse response=new ExceptionResponse(message, new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
