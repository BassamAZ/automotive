package com.automotive.customer.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

import com.automotive.customer.model.Customer;
import com.automotive.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Test
    public void getAllCustomers() {

        CustomerService mockCustomerService=mock(CustomerService.class);

        List<Customer> mockCustomerList= new ArrayList<Customer>(){ 
        	
			private static final long serialVersionUID = 1L;

		{add(new Customer("33333","Software Eng","Dubai","name","21",Stream.of("1","2").collect(Collectors.toList())));  }} ;

        Mockito.when(mockCustomerService.findAll()).thenReturn(mockCustomerList);

        CustomerController customerController=new CustomerController();
        customerController.setCustomerService(mockCustomerService);

        List<Customer> customerList=customerController.getAllCustomers();

        Assert.assertEquals(customerList.size(),1);


    }

    @Test
    public void getCustomer() {

        CustomerService mockCustomerService=mock(CustomerService.class);

        Customer mockCustomer= new Customer("33333","name","Software Eng","Dubai","21",Stream.of("1","2").collect(Collectors.toList())) ;

        Mockito.when(mockCustomerService.findById("33333")).thenReturn(mockCustomer);

        CustomerController customerController=new CustomerController();
        customerController.setCustomerService(mockCustomerService);

        Customer customer=customerController.getCustomer("33333");

        Assert.assertEquals(customer.getName(),"name");
    }

    @Test
    public void registerCustomer() {

        CustomerService mockCustomerService=mock(CustomerService.class);

        Customer mockCustomer= new Customer("33333","name","Software Eng","Dubai","21",Stream.of("1","2").collect(Collectors.toList())) ;

        Mockito.when(mockCustomerService.createCustomer(mockCustomer)).thenReturn(mockCustomer);

        CustomerController customerController=new CustomerController();
        customerController.setCustomerService(mockCustomerService);

        Customer customer=customerController.registerCustomer(mockCustomer);

        Assert.assertEquals(customer.getName(),"name");
    }

    @Test
    public void getDummyCustomer() {

        CustomerService mockCustomerService=mock(CustomerService.class);

        Customer mockCustomer= new Customer("33333","name","Software Eng","Dubai","21",Stream.of("1","2").collect(Collectors.toList())) ;

        Mockito.when(mockCustomerService.findDummyCustomer()).thenReturn(mockCustomer);

        CustomerController customerController=new CustomerController();
        customerController.setCustomerService(mockCustomerService);

        Customer customer=customerController.getDummyCustomer("33333");

        Assert.assertEquals(customer.getName(),"name");
    }
}