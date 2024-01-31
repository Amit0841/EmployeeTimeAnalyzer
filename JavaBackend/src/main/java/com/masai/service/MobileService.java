package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Mobile;
import com.masai.model.Orders;


@Service
public class MobileService implements MobileServiceInterface{

	List<Mobile> mobileList=new ArrayList<>(List.of(
			new Mobile(1, "PT Wireless CP-Z32G", 399.99, "https://www.techcart.in/wp-content/uploads/2020/05/CP-PLUS-COSMIC-BULLET-1MP-CCTV-CAMERA-300x300.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(2, "DAHUA DOME T1A21P", 499.99, "https://www.techcart.in/wp-content/uploads/2022/02/CP-PLUS-5MP-DOME-CAMERA-USC-DC51PL2-V3-0360.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(3, "D-LINK 2MP DOME ", 399.99, "https://www.techcart.in/wp-content/uploads/2022/09/51W2IAoPBDL._SX425_-300x300.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(4, "CP PLUS 2.4 DOME", 309.99, "https://www.techcart.in/wp-content/uploads/2022/02/CP-PLUS-2.4-DOME-CAMERA-GPC-D24L2.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(5, "INTEL® PROCESSOR", 399.99, "https://www.techcart.in/wp-content/uploads/2021/10/INTEL%C2%AE-PENTIUM%C2%AE-GOLD-G6405-DESKTOP-PROCESSOR-300x300.gif", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(6, "ASUS Prime H610-E", 399.99, "https://www.techcart.in/wp-content/uploads/2023/11/asush-610-300x300.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(8, "CP PLUS WIRELESS", 399.99, "https://www.techcart.in/wp-content/uploads/2022/09/download-2.jpg", "DescriptionA", "CompanyX", "Category1", "4GB"),
			new Mobile(13, "AMD RYZEN 7 3700X", 399.99, "https://www.techcart.in/wp-content/uploads/2021/10/AMD-RYZEN-7-3700X-PROCESSOR-300x300.gif", "DescriptionA", "CompanyX", "Category1", "4GB"))

			);
	
	
	public Mobile add(Mobile mobile) {
//		mobileRepository.save(mobile);
		return mobile;
	}
	@Override
	public List<Mobile> getMobiles() {
		
		return mobileList;
	}
	@Override
	public Mobile getMobilesById(Integer mobileId) {
		
		return null;
	}
	
	@Override
	public Mobile addToCart(Cart cart, Integer customerId, Integer mobileId) {
//		Optional<Mobile> m=mobileRepository.findById(mobileId);
//		Optional<Customer> cus=customerRepository.findById(customerId);
//		Cart c=cartRepository.findByCustomerAndMobile(cus.get(),m.get());
//		if(c!=null) {
//			throw new  RuntimeException("Item already added");
//		}else {
//			cart.setCustomer(cus.get());
//			cart.setMobile(m.get());
//		cartRepository.save(cart);	
//		return m.get();
//		}
	return null;
	}
	@Override
	public List<Mobile> getCart(Integer customerId) {
//		Optional<Customer> cus=customerRepository.findById(customerId);
//		
//		List<Cart> list=cartRepository.findAll();
//		List<Mobile> l=new ArrayList();
//		for(Cart c:list) {
//			if(c.getCustomer().getCustomerId()==customerId) {
//				l.add(c.getMobile());
//			}
//		}
		return null;
	}
	
	@Override
	public Cart deleteCart(Integer customerId, Integer mobileId) {
		 
//		cartRepository.deleteByCustomerIdAndMobileId(customerId,mobileId);
//		List<Cart> c=cartRepository.findAll();
//		for(Cart c1:c) {
//			if(c1.getCustomer().getCustomerId()==customerId && c1.getMobile().getMobileId()==mobileId) {
//				cartRepository.delete(c1);
//			}
//		}
		return null;
	}
	
	@Override
	public Cart orderCart(Integer customerId) {
//Optional<Customer> cus=customerRepository.findById(customerId);
//		
//		List<Cart> list=cartRepository.findAll();
//		List<Cart> list1=new ArrayList();
//		List<Mobile> l=new ArrayList();
//		for(Cart c:list) {
//			if(c.getCustomer().getCustomerId()==customerId) {
//				l.add(c.getMobile());
//				list1.add(c);
//			}
//		}
//		Orders o=new Orders();
//		o.setCustomer(cus.get());
//        o.setCart(list1);
//		orderRepository.save(o);
		return null;
	}
	
	@Override
	public List<Orders> getOrder(Integer customerId) {
//		List<Orders> ord=orderRepository.findByCustomerCustomerId(customerId);
		return null;
	}
	@Override
	public List<Mobile> find( String name) {
		
//		List<Mobile> mobile=mobileRepository.findByMobileNameIgnoreCaseContaining(name);
		
		return null;
	}
	@Override
	public Mobile deleteById(Integer mobileId) {
//		Optional<Mobile> mobile=mobileRepository.findById(mobileId);
//		mobileRepository.deleteById(mobileId);
		return null;
	}

}
