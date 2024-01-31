package com.masai.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Orders {

		private int orderId;
	    private Date orderDate;
	    
//	    @ManyToOne
//	    @JoinColumn(name="customer_id")
//	    private Customer customer;
//	    
//	    private String status;
//	    @OneToMany
//	    private List<Cart> cart;
}
