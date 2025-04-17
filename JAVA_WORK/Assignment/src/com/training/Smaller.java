package com.training;

public class Smaller {

	public static void main(String[] args) {
		int[] numbers = {10, 60, 30,40,50};
		int a=numbers[0];
		for (int i=1;i<numbers.length;i++) {
			if (numbers[i] < a) {
				a=numbers[i];
				
				
			}
			
		}
		System.out.println("Smallest number is"+a);
	}

}
