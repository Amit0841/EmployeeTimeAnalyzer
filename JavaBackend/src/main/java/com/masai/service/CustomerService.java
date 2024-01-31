package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;

@Service
public class CustomerService implements CustomerServiceInterface{
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customer;
	}

}
