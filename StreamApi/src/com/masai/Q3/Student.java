package com.masai.Q3;

public class Student {
	private int rollNo ;
	private String name ;
	private String subject ;
	private double marks ;
	
	public Student(int rollNo, String name, String subject, double marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", subject=" + subject + ", marks=" + marks + "]";
	}

}
