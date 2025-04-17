package com.training;

public class Sum {

	public static void main(String[] args) {
		int[] numbers = {10, 60, 30,40,50};
		int sum = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            while (num > 0) {
                int digit = num %10;
                sum += digit;
                count++;
                num = num / 10;
                
            }
        }
        double average = (double) sum / count;

        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + average);

        
	}

}
