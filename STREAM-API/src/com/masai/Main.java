package com.masai;

import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
	List <Product> product =new ArrayList<>();
product.add(new Product(1,"a",51,13));
product.add(new Product(1,"e",56,6));
product.add(new Product(2,"b",60,30));
product.add(new Product(3,"c",36,18));
product.add(new Product(1,"d",85,8));

List <Product> l=product.stream().filter(s -> s.getQuantity()>=10).sorted((a,b) -> a.getPrice()>b.getPrice()?-1:1).toList();

product.forEach(p->System.out.println(p));
System.out.println("Filtered list");
l.forEach(p->System.out.println(p));

	}

}
