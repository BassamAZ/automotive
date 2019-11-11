package com.automotive.customer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automotive.customer.model.Customer;
import com.automotive.customer.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/automotive")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List <Customer> getAllCustomers(){
		return customerService.findAll();
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id")String id){
		return customerService.findById(id);

	}

	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);

	}


	public Customer getDummyCustomer(String id){
		return customerService.findDummyCustomer();
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}
}
