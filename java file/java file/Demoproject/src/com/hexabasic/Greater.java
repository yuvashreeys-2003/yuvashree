package com.hexabasic;

public class Greater {

	public static void main(String[] args) {
		int num1 = 50;
		int num2 = 9;
		int num3 = 12;
		if (num1 > num2 && num1 > num3) {
			System.out.println("Greater value is" + num1);

		} else if (num2 > num3) {
			System.out.println("Greater value" + num2);

		} else {
			System.out.println("Greater value" + num3);
		}

	}

}
