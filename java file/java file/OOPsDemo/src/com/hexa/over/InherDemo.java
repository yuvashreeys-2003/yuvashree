package com.hexa.over;

public class InherDemo {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("RX100", 90000);
		vehicle.printDetails();

		Car car = new Car("BenZ", 1000000, "RGBSound bar");
		car.printDetails();
		car.showAccessories();

	}

}
