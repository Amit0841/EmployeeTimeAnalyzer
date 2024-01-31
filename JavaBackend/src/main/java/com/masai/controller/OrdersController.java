package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Orders;
import com.masai.service.MobileServiceInterface;

@RestController
@CrossOrigin(origins = "*")
public class OrdersController {
	@Autowired
	private MobileServiceInterface mobileServiceInterface;

	@PostMapping("order/{customerId}")
	public ResponseEntity<Cart> orderCart(@PathVariable Integer customerId){
		return new ResponseEntity<Cart>(mobileServiceInterface.orderCart(customerId), HttpStatus.OK);
	}
	
	@GetMapping("order/{customerId}")
	public ResponseEntity<List<Orders>> getOrder(@PathVariable Integer customerId){
		return new ResponseEntity<List<Orders>>(mobileServiceInterface.getOrder(customerId), HttpStatus.OK);
	}
	
}
