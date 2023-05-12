package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
public static void main(String[] args) {
	List<Customer> list =new ArrayList<>();
	list.add(new Customer("a",50,"m","dss"));
	list.add(new Customer("b",15,"m","twfgd"));
	list.add(new Customer("c",34,"m","drt"));
	list.add(new Customer("d",29,"m","drts"));
	list.add(new Customer("e",32,"f","srtd"));
	list.add(new Customer("f",22,"m","ryrsd"));
	
	List<Customer> filteeredList= list.stream().filter(a->a.getAge()>=30).toList();

	Consumer<Customer> cun=(as->System.out.println(as));
	filteeredList.forEach(cun);

	List <String> l = list.stream().map(a->a.getName()).toList();
	l.forEach(a->System.out.println(a));
	
	List<Customer> l1 = list.stream().sorted((s1,s2)->s1.getAge()>s2.getAge()?1:-1).toList();
	l1.forEach(a->System.out.println(a));
}


}
