package com.automotive.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutomotiveCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotiveCustomerApplication.class, args);
	}

}
