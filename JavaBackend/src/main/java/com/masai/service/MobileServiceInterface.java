package com.masai.service;

import java.util.List;

import com.masai.model.Cart;
import com.masai.model.Mobile;
import com.masai.model.Orders;

public interface MobileServiceInterface {

	Mobile add(Mobile mobile);

	List<Mobile> getMobiles();

	Mobile getMobilesById(Integer mobileId);

	Mobile addToCart(Cart cart, Integer customerId, Integer mobileId);

	List<Mobile> getCart(Integer customerId);

	Cart deleteCart(Integer customerId, Integer mobileId);

	Cart orderCart(Integer customerId);

	List<Orders> getOrder(Integer customerId);

	List<Mobile> find( String name);

	Mobile deleteById(Integer mobileId);

}
