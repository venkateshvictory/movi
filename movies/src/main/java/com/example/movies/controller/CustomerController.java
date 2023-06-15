package com.example.movies.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.entity.Customer;
import com.example.movies.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Resource(name="customerService")
	private CustomerService custeoService;
	
	@PostMapping("/")
	public Customer save(@RequestBody Customer customer) {
		return custeoService.save(customer);
	}
}
