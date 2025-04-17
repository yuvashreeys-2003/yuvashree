package com.hexabasic;

public class WeatherReport {

	public static void main(String[] args) {
		String choice = "";
		switch (choice) {
		case "Rainy":
			System.out.println("Drink Hot tea");
			break;
		case "Summer":
			System.out.println("Eat Icecream");
			break;
		case "Winter":
			System.out.println("Drink Soup");
			break;
		case "Spring":
			System.out.println("Enjoy the blooms");
			break;
		default:
			System.out.println("You made the wrong choice");
		}

	}

}
