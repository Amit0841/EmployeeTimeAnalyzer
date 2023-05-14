 package com.masai.Q1;

import java.util.*;

public class Main {
	
	public static void findNegativeOnly(List<Integer> list5,List<Double> list2,List<? super Number> list3) {
		
		 list5.forEach(e1 -> {
			 if(e1.doubleValue()<0) {
				 list3.add(e1);
			 }
		 });
		 
		 list2.forEach(e1 -> {
			 if(e1.doubleValue()<0) {
				 list3.add(e1);
			 }
		 });
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1= new ArrayList<>();
		list1.add(-1);
		list1.add(1);
		list1.add(-2);
		list1.add(3);
		
		System.out.println("The first list is "+list1);
		List<Double> list2= new ArrayList<>();
		list2.add(-1.0);
		list2.add(1.0);
		list2.add(-2.0);
		list2.add(3.0);
		System.out.println("The second list is "+list2);
		List<Number> list3=new ArrayList<>();
		
		findNegativeOnly(list1,list2,list3);
		System.out.println("Negative elements are" +" " +list3);
		

	}

}
