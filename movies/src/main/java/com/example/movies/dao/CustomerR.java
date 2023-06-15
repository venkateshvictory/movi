package com.example.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.entity.Customer;
@Repository("customer")
public interface CustomerR extends JpaRepository<Customer, Long>{

}
