package com.microservice.user.Exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException() {
		super("Resourse Not Found on the server!!");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
