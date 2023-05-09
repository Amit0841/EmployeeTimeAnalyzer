package com.masai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
public static void main(String[] args) {
	List <Product> list=new ArrayList<>();

	list.add(new Product(1,"Iphone1",2,80500));
	list.add(new Product(2,"Iphone2",5,70500));
	list.add(new Product(3,"Iphone3",2,86000));
	list.add(new Product(4,"Iphone4",5,75000));
	list.add(new Product(5,"Iphone5",6,599990));
	list.add(new Product(5,"Iphone5",17,599990));
	Collections.sort(list, new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			 int priceComp = Integer.compare(p2.getPrice(), p1.getPrice());
		        if (priceComp != 0) {
		            return priceComp;
		        }

		        // Sort in descending order of quantity
		        int qtyComp = Integer.compare(p2.getQuantity(), p1.getQuantity());
		        if (qtyComp != 0) {
		            return qtyComp;
		        }

		        // Sort in descending order of product name
		        int nameComp = p2.getProductName().compareTo(p1.getProductName());
		        if (nameComp != 0) {
		            return nameComp;
		        }

		        // Sort in descending order of product id
		        return Integer.compare(p2.getProductId(), p1.getProductId());
			
		}
		
	} );
	for (Product p : list) {
	    System.out.println(p);
	}
	
}
}
