package com.hexa.inheritance;

public class EmpMain {

	public static void main(String[] args) {
		Employee employee= new Employee("Kumar",26000);
		employee.printDetails();
		
		Manager manager= new Manager("Kathi",78000,"chennai");
		manager.printDetails();
		manager.showCity();
		
		

	}

}
