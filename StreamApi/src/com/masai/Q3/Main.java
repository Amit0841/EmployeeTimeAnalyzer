package com.masai.Q3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StudentObject stu=Student::new;
		Student st=stu.createObject(1, "amit", "math", 80);
		
		StudentToString student = st::toString;
		
		System.out.println(student.studentString());
		List <Student> stud=new ArrayList<>();
		
		stud.add(stu.createObject(2, "a", "s", 50));
		stud.add(stu.createObject(12, "g", "st", 53));
		stud.add(stu.createObject(21, "h", "sys", 50));
		stud.add(stu.createObject(22, "j", "ls", 90));
		
		StdOp sh=StudentOperations::getStudentWithMaximumMarks;
		System.out.println(sh.studentOpString(stud));
		
		StudentHas sth= Student::hashCode;
		stud.forEach(s->System.out.println(sth.stdHas(s)));
	}
}
