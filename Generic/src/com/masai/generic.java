package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class generic <t> {
List <t> list=new ArrayList<>();
void push(t i) {
	list.add(i);
}
void pop() {
	list.remove(list.size()-1);
}
void peek () {
	System.out.println(list.get(list.size()-1));
}
void show() {
	for(int i=0;i <list.size();i++) {
		System.out.println(list.get(i)); 
	}
}
public static void main(String[] args) {
	Scanner sc=new Scanner (System.in);
	generic g=new generic();
	
	int c=0;
	do {
		System.out.println("1. push");
		System.out.println("2. pop");
		System.out.println("3. peek");
		System.out.println("4. show");
		System.out.println("0. Exit");
		System.out.println("Enter :");
		c=sc.nextInt();
		switch(c) {
		case 1:
			System.out.println("Enter Input");
			String a=sc.next();
			g.push(a);
			break;
		case 2:
			g.pop();
			break;
		case 3:
			g.peek();
			break;
		case 4:
			g.show();
			break;
		case 0:
			System.out.println("Exit");
			break;
			default :
				System.out.println("Wrong input");
				break;
		}
	}while(c!=0);
	
 }
}
