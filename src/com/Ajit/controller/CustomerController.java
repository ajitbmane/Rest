package com.Ajit.controller;


import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Ajit.entity.Customer;
import com.Ajit.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping(value = "/customer")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		return theCustomer;
	}
		
	

//	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
//	public void addCountry(@RequestBody Country country) {	
//		countryService.addCountry(country);
//		
//	}
//	@RequestMapping( value="/customer",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void saveCustomer(@RequestBody Customer theCustomer) {
//		System.out.println(theCustomer.getFirstName());
//		System.out.println(theCustomer.getLastName());
//		System.out.println(theCustomer.getEmail());
//		// save the customer using our service
//		customerService.saveCustomer(theCustomer);	
//		}
//	
	

	@PostMapping("/customer")
	public void saveCustomer(@RequestBody Customer theCustomer) {
		
		System.out.println(theCustomer.getFirstName());
        System.out.println(theCustomer.getLastName());
		System.out.println(theCustomer.getEmail());
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		
	}
	
	
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer theCustomer) {
		System.out.println(theCustomer.getFirstName());
        System.out.println(theCustomer.getLastName());
		System.out.println(theCustomer.getEmail());
		customerService.saveCustomer(theCustomer);
	}
	
	@DeleteMapping("/customer/{customerId}")
public void deleteCustomer(@PathVariable("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
	}

	
	
}























