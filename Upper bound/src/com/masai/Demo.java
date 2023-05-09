package com.masai;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	static void findStudentWithSameState(List <Student> list1, List <? extends Student> list2, List <? extends Student> list3,String state) {
		for(Student a:list2) {
			if(a.state.equals(state)) {
				list1.add(a);
			}
		}
		for(Student a:list3) {
			if(a.state.equals(state)) {
				list1.add(a);
			}
		}
	}
	
public static void main(String[] args) {
	List <SchoolStudent> arr1=new ArrayList<>();
	arr1.add(new SchoolStudent(1, "Amit", "New York", "ABC Board"));
	 arr1.add(new SchoolStudent(2, "Rakesh", "California", "XYZ Board"));
	 arr1.add(new SchoolStudent(3, "Riju", "Texas", "PQR Board"));
	 arr1.add(new SchoolStudent(4, "Sujoy", "California", "ABC Board"));
	 arr1.add(new SchoolStudent(5, "Biplob", "New York", "PQR Board"));
	 
	List <CollegeStudent> arr2=new ArrayList<>();
	arr2.add(new CollegeStudent(501, "Dip", "Texas", "UVW University"));
	 arr2.add(new CollegeStudent(502, "Sri", "New York", "XYZ University"));
	 arr2.add(new CollegeStudent(503, "Emli", "California", "UVW University"));
	 arr2.add(new CollegeStudent(504, "jon", "Texas", "PQR University"));
	 arr2.add(new CollegeStudent(505, "olivia", "California", "ABC University"));
	List <Student> list1=new ArrayList<>();
	 
	findStudentWithSameState(list1,arr1,arr2,"California");
	System.out.println(list1);
}

}
