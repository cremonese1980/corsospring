package a_allcontests.projecteuler.n_020_factorialDigitSum;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static final int N_MAX = 1000;
	
	private static Map<Integer, BigInteger> factorialMap;
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		buildData();
		
		for (int i = 0; i < t; i++) {
					
			int n = scanner.nextInt();
			
			System.out.println(getSolution(n));
		}
		
		scanner.close();
		
		
		
		
	}

	private static void buildData() {

		factorialMap = new HashMap<Integer, BigInteger>();
		factorialMap.put(0, BigInteger.ONE);
		
		BigInteger currFactorial = BigInteger.ONE;
		
		for (int n = 1; n <= N_MAX; n++) {
			
			currFactorial = currFactorial.multiply(new BigInteger(String.valueOf(n)));
			factorialMap.put(n, currFactorial);
			
		}
		
	}

	private static int getSolution(int n) {

		String nAsString = factorialMap.get(n).toString();
		int count = 0;
		
		for (int i = 0; i < nAsString.length(); i++) {
			
			count+= Integer.parseInt(nAsString.substring(i, i+1));
			
		}
		
		return count;
		
	}


}
