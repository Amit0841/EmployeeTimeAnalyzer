package com.masai;

public class SchoolStudent extends Student{
String boardName;

	public SchoolStudent(int rollNo, String name, String state,String boardName) {
		super(rollNo, name, state);
		this.boardName=boardName;
	}

	@Override
	public String toString() {
		return "SchoolStudent [boardName=" + boardName + ", rollNo=" + rollNo + ", name=" + name + ", state=" + state
				+ "]";
	}



}
