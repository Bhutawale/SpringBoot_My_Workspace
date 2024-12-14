package com.microservice.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration 
{
	@Bean
	public RestTemplate resttemplate()
	{
		return new RestTemplate();
		
	}
}