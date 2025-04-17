package com.hexa.inheritance;

public class Employee {
	String empName;
	int salary;
	public Employee(String empName, int salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}
	void printDetails() {
		System.out.println("Employe name"+empName);
		System.out.println("Salary"+salary);
	}
	

		

	

}
