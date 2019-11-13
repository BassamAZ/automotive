package com.automotive.registery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AutomotiveRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotiveRegisteryApplication.class, args);
	}

}
