package com.masai;

public abstract class Student {
	int rollNo ; 
	String name;
    String state ;
	public Student(int rollNo, String name, String state) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", state=" + state + "]";
	}
	
}
