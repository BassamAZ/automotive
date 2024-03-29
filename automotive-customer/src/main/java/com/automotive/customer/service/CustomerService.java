package com.automotive.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotive.customer.model.Customer;
import com.automotive.customer.repo.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List <Customer> findAll(){
        return customerRepository.findAll();
    }


    public Customer findById( String  id){

        if (StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("There is a missing: id");
        }

        return customerRepository.findById(id).orElse(null);
    }


    public Customer createCustomer( Customer  customer){

        if (customer==null){
            throw new IllegalArgumentException("There is a object: customer");
        }

        return customerRepository.save(customer);
    }

    public Customer findDummyCustomer(){

        Customer customer= new Customer();
        customer.setName("Dummy Name");

        List <String> vehicleIds= new ArrayList<String>();

        vehicleIds.add("22");
        vehicleIds.add("33");
        vehicleIds.add("44");
        vehicleIds.add("55");
        vehicleIds.add("66");

        customer.setVehicleIds(vehicleIds);

        return customer;
    }
    public Customer linkVehicleToCustomer( String vehicleId, String customerId){

    	Customer customer = findById(customerId);
    	
    	if(customer.getVehicleIds() != null) {
    		customer.getVehicleIds().add(vehicleId);
    	}else {
    		customer.setVehicleIds(new ArrayList<>());
    		customer.getVehicleIds().add(vehicleId);
    		
    	}
    	
    	
        return customerRepository.save(customer);
    }

}
