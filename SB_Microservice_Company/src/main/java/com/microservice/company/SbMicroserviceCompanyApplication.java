package com.microservice.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbMicroserviceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroserviceCompanyApplication.class, args);
	}

}
