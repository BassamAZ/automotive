package com.automotive.customer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.automotive.customer.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String> {

}
