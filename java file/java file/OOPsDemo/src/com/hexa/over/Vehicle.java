package com.hexa.over;

public class Vehicle {

	private String model;
	private int price;
	

	public Vehicle(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}


	void printDetails() {
		System.out.println("ModelName:" + model);
		System.out.println("Price:" + price);

	}

}
