package com.masai;

public class Customer {
    private String name;
    private int age;
    private String gender;
    private String city;
   
	public Customer(String name, int age, String gender, String city) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city + "]";
	}
	
}