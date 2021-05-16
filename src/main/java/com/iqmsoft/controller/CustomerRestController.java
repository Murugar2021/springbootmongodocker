package com.iqmsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.model.Customer;
import com.iqmsoft.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/customers")
	public List<Customer> findAll(){
		final List<Customer> customers = repository.findAll();
		log.info("Fetching customers from database {}" , customers);
		return customers;
	}
	
	@RequestMapping(value = "/customer" , method = RequestMethod.POST)
	public void save(@RequestBody Customer customer){
		log.info("Storing customer in database {}", customer);
		repository.save(customer);
	}
	
}
