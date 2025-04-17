package com.hexa.basic;

public class EmpMain {
	
	public static void main(String[] args) {

		Employee employee = new Employee("Alan", 1900);
		employee.printDetails();
		String result = employee.greet();
		System.out.println(result);
		employee.calcBonus(1000);
		System.out.println();

		Employee employee1 = new Employee("Akash", 1000);
		employee1.printDetails();
		String result1 = employee1.greet();
		System.out.println(result1);
		employee.calcBonus(900);

	}

}
