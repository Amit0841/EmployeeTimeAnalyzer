package com.masai.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
	
	private int mobileId;
	
	private String mobileName;
	
	private double price;
	
	private String image;
	
	private String mobileDescription;
	
	private String companyName;
	
	private String category;
	
	private String ram;
	

}
