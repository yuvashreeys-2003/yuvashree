package com.hexa.inheritance;

public class Manager extends Employee {
	String city;

	public Manager(String empName, int salary, String city) {
		super(empName, salary);
		this.city = city;
	}
	void showCity() {
		System.out.println("Cityname"+city);
	}

	
	

}
