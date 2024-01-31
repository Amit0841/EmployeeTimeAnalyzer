
package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
	
	private int customerId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String mobileNumber;
	
	private String address;
	
	private String role;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "customer")
//	private List<Orders> orderList1=new ArrayList<>();
	


	
}
