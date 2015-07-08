package com.ecerejo;

import java.util.ArrayList;
import java.util.List;

/*
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000. 
 */

public class Problem48 {
	
	public static void main(String[] args) {
		
		Problem48 problem = new Problem48();
		System.out.println(problem.resolve(1000));
	}
		
	private int resolve(int num) {
		
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			
			List<Integer> parcial = initialize(i);
			
			for (int j = 1; j < i; j++) {
				parcial = multiply(parcial, i);
			}
			
			result = sum(result, parcial);
			
			if(result.size() > 10) {
				result = result.subList(0, 10);
			}
		}
		return convertToInt(result);
	}
	

	private int convertToInt(List<Integer> result) {
		String output = ""; 
		for (Integer digit : result) {
			output = digit + output;
		}
		return Integer.parseInt(output);
	}

	private List<Integer> sum(List<Integer> result, List<Integer> parcial) {
		
		int temp;

		int up = 0;
		int index = 0;
		
		while(index < result.size() && index < parcial.size()) {
			temp = result.get(index) + parcial.get(index) + up;
			result.set(index, lastNumber(temp));
			up = decimalNumber(temp);
			index++;
		}
		
		while(index < result.size()) {
			temp = result.get(index) + up;
			result.set(index, lastNumber(temp));
			up = decimalNumber(temp);
			index++;
		}
		
		while(index < parcial.size()) {
			temp = parcial.get(index) + up;
			result.add(lastNumber(temp));
			up = decimalNumber(temp);
			index++;
		}
		
		while (up > 0) {
			result.add(lastNumber(up));
			up = decimalNumber(up);
		}
		
		return result;
	}

	private List<Integer> multiply(List<Integer> current, int unit) {
		
		List<Integer> number = new ArrayList<Integer>();
		int up = 0;
		
		for(Integer digit : current) {
				int result = (digit * unit) + up;
				number.add(lastNumber(result));
				up = decimalNumber(result);
		}
		
		if (up > 0) {
			number = addParcial(number, up);
		}
		
		return number;
	}
	
	private List<Integer> addParcial(List<Integer> number, int up) {
		
		while (up > 0) {
			number.add(lastNumber(up));
			up = decimalNumber(up);
		}
		return number;
	}

	private List<Integer> initialize(int value) {
		
		List<Integer> valueAsList = new ArrayList<Integer>();
		while (value > 0) {
			valueAsList.add(lastNumber(value));
			value = decimalNumber(value);
		}
		return valueAsList;
	}

	private int lastNumber(int num) {
		return num%10;
	}
	
	private int decimalNumber(int num) {
		return num/10;
	}
	
}
