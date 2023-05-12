package com.masai;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args) {
	
	List<Fruit> fruits = Arrays.asList(
			new Fruit("Orange", 10, 89),
			new Fruit("Papaya", 20, 90),
			new Fruit("Apple", 10, 45),
			new Fruit("Watermelon", 10, 56),
			new Fruit("Guava", 10, 40),
			new Fruit("Pomegranate", 10, 200)
		);
	Map<String, Double> map= fruits.stream().collect(Collectors.toMap( Fruit::getName,  f -> f.getPrice() * f.getQuantity() ));
	System.out.println(map);
	double sum=fruits.stream().mapToDouble(f -> f.getPrice() * f.getQuantity()).sum();
	System.out.println(sum);
	
	List <Fruit> list=fruits.stream().filter(a->a.getPrice()>=50).sorted((a,b)->a.getPrice()>b.getPrice()?1:-1).toList();
	
	List <Fruit> list2=list.stream().skip(2).limit(2).toList();
	
	list2.forEach(a->System.out.println(a));
}
}