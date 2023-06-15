package com.example.movies.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.movies.dao.CustomerR;
import com.example.movies.entity.Customer;




@Service("customerService")
public class CustomerService {

	@Resource(name="customer")
	private CustomerR customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}
