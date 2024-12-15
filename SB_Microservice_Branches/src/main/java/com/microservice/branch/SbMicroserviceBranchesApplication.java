package com.microservice.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbMicroserviceBranchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroserviceBranchesApplication.class, args);
	}

}
