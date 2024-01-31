package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
	

	@Autowired
	private CustomerServiceInterface customerServiceInterface;
	

	// customer Register
	@PostMapping("/add")
	ResponseEntity<Customer> registerUser( @RequestBody Customer customer){
		
		customer.setRole("user");
		System.out.println("working");
		return new ResponseEntity<Customer>(customerServiceInterface.addCustomer(customer),HttpStatus.CREATED);
	}
	
	//customer Login
//	@GetMapping("/logini")
//	public ResponseEntity<Customer> logInUserHandler(Authentication auth){
////		 Optional<Customer> opt= customerRepository.findByEmail(auth.getName());
//		 
////		 if(opt.isEmpty()) throw new RuntimeException("No user found") ;
////		 Customer user = opt.get();
//		 
//		 return new ResponseEntity<Customer>(user, HttpStatus.OK);
//	}
}
