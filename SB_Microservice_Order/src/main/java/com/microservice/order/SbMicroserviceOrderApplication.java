package com.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbMicroserviceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroserviceOrderApplication.class, args);
	}

}
