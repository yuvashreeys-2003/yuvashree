package com.hexa.basic;

public class Student {
	String studentName;
	String city;

	public static void main(String[] args) {
		Student student = new Student();
		student.studentName = "Hari";
		student.city = "Chennai";
		System.out.println("Name:" + student.studentName);
		System.out.println("city:" + student.city);

		Student student1 = new Student();
		student1.studentName = "Kumar";
		student1.city = "Selam";
		System.out.println("Name:" + student1.studentName);
		System.out.println("city:" + student1.city);

	}

}
