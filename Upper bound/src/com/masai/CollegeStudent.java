package com.masai;

public class CollegeStudent extends Student{
	String universityName;
	
public CollegeStudent(int rollNo, String name, String state, String universityName) {
		super(rollNo, name, state);
		this.universityName=universityName;
	}

@Override
public String toString() {
	return "CollegeStudent [universityName=" + universityName + ", rollNo=" + rollNo + ", name=" + name + ", state="
			+ state + "]";
}



}
