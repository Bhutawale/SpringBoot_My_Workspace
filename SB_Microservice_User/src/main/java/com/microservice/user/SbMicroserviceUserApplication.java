package com.microservice.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbMicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroserviceUserApplication.class, args);
	}

}
