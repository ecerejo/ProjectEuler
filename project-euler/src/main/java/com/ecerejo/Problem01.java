package com.ecerejo;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem01 {

	public static void main(String[] args) {
		
		Problem01 problem01 = new Problem01();
		System.out.println(problem01.resolve(1000));
		
	}

	private int resolve(int range) {
		
		int sum = 0;
		
		for (int i = 1; i < range; i++) {
			if (i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
}
