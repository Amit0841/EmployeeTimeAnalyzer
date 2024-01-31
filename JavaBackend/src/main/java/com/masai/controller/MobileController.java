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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Mobile;
import com.masai.service.MobileServiceInterface;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mobile")
public class MobileController {
	@Autowired
	private MobileServiceInterface mobileServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<Mobile> addMobile(@RequestBody Mobile mobile){
		return new ResponseEntity<Mobile>(mobileServiceInterface.add(mobile), HttpStatus.CREATED);
		
	}
	@GetMapping("/get")
	public ResponseEntity<List<Mobile>> getMobile(){
		return new ResponseEntity<List<Mobile>>(mobileServiceInterface.getMobiles(), HttpStatus.OK);
		
	} 
	@GetMapping("/get/{mobileId}")
	public ResponseEntity<Mobile> getMobileById(@PathVariable Integer mobileId){
		return new ResponseEntity<Mobile>(mobileServiceInterface.getMobilesById(mobileId), HttpStatus.OK);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<List<Mobile>> find(@PathVariable String name){
		return new ResponseEntity<List<Mobile>>(mobileServiceInterface.find(name), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{mobileId}")
	public ResponseEntity<Mobile> delete(@PathVariable Integer mobileId){
		return new ResponseEntity<Mobile>(mobileServiceInterface.deleteById(mobileId), HttpStatus.OK);
	}
}
