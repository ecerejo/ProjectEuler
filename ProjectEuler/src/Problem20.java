import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Problem20 {
	public static void main(String[] args) {
		
		Problem20 problem = new Problem20();
		System.out.println(problem.sumFat(100));
	}
		
	private int sumFat(int i) {
		
		List<Integer> result = fat(i);
		int sum = 0;
		
		for (Integer digit : result) {
			sum += digit;
		}
		return sum;
	}

	private List<Integer> fat(int num) {
		
		List<Integer> result = Arrays.asList(1);
		
		for (int i = 1; i <= num; i++) {
			result = multiply(result, i);
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

	private int lastNumber(int num) {
		return num%10;
	}
	
	private int decimalNumber(int num) {
		return num/10;
	}
}
