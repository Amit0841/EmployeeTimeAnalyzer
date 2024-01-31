package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Mobile;
import com.masai.service.MobileServiceInterface;

@RestController
@CrossOrigin(origins = "*")
public class CartController {
	@Autowired
	private MobileServiceInterface mobileServiceInterface;

	@PostMapping("/cart/{customerId}/{mobileId}")
	public ResponseEntity<Mobile> addToCart(@RequestBody Cart cart,@PathVariable Integer customerId,@PathVariable Integer mobileId){
		return new ResponseEntity<Mobile>(mobileServiceInterface.addToCart(cart,customerId,mobileId), HttpStatus.CREATED);
	}
	@GetMapping("/cart/{customerId}")
	public ResponseEntity<List<Mobile>> getCart(@PathVariable Integer customerId){
		return new ResponseEntity<List<Mobile>>(mobileServiceInterface.getCart(customerId), HttpStatus.OK);
	}
	@DeleteMapping("/cart/delete/{customerId}/{mobileId}")
	public ResponseEntity<Cart> deleteCart(@PathVariable Integer customerId,@PathVariable Integer mobileId){
		return new ResponseEntity<Cart>(mobileServiceInterface.deleteCart(customerId,mobileId), HttpStatus.OK);
	}

}
