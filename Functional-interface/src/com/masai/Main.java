package com.masai;

import java.util.*;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		List<Student> studentlist=new ArrayList<>();
		
		Scanner sc=new Scanner(System.in);
		
		int i=2;
		while(i>0) {
			System.out.println("Enter roll");
			int roll=sc.nextInt();
			System.out.println("Enter Name");
		String name=sc.next();
			System.out.println("Enter Marks");
			int Marks=sc.nextInt();
			i--;
			studentlist.add(new Student(roll, name, Marks));
		}
		Function<List<Student>,Map<String,List<Student>>>  result = (list) ->{
			
			List<Student> Pass=new ArrayList<>();
			List<Student> Fail=new ArrayList<>();
			List<Student> Topper=new ArrayList<>();
			
			list.forEach(p -> {
				if(p.getMarks()<165) {
					Fail.add(p);
					
				}
				else if(p.getMarks()<400) {
					Pass.add(p);
				}
				else {
					Topper.add(p);
				}
			});
			Map<String,List<Student>> map=new HashMap<>();
			
			map.put("PASS", Pass);
			map.put("FAIL", Fail);
			map.put("TOPPER", Topper);
			
			return map;
		};
		Map<String,List<Student>> map=result.apply(studentlist);
		map.forEach((k ,V) -> System.out.println(k +" : "+V) );
	}
}
