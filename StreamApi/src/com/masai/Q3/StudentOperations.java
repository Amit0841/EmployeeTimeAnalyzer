package com.masai.Q3;

import java.util.List;

public class StudentOperations {
	static String getStudentWithMaximumMarks(List<Student> studentList) {
		String topper="";
		double highMarks=0.0;
		for(Student s:studentList) {
			if(s.getMarks()>highMarks) {
				highMarks=s.getMarks();
				topper=s.getName();
			}
		}
		return topper;
	}
}
@FunctionalInterface
interface StudentObject {
	Student createObject(int roll,String name, String sub, double marks);
}
@FunctionalInterface
interface StudentToString {
	String studentString();
}
@FunctionalInterface
interface StdOp {
	String studentOpString(List<Student> list);
}
@FunctionalInterface
interface StudentHas {
	int stdHas(Student s);
}