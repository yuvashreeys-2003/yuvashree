package com.hexa.over;

public class Car extends Vehicle{
	 private String accessories;
	
	
	public Car(String model, int price, String accessories) {
		super(model, price);
		this.accessories = accessories;
	}


	void showAccessories() {
		System.out.println("Add Accessories:"+accessories);


	}
}