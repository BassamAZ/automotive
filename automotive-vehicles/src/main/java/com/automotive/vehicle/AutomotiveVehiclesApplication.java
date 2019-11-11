package com.automotive.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutomotiveVehiclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotiveVehiclesApplication.class, args);
	}

}
