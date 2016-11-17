package a_allcontests.projecteuler.n_016_Powerdigitsum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	
	private static final int LIMIT = 100;
	private static final BigInteger TWO_POW_1000 = new BigDecimal(Math.pow(2, LIMIT)).toBigInteger();
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {

			int exp = scanner.nextInt();
			
			System.out.println(getSolution(exp));
			
			
		}
		
		scanner.close();
		
	}

	private static int getSolution(int exp) {

		BigInteger pow = getPow(exp);
		
		String powAsString = pow.toString();
		
		int sum = 0;
		
		for (int i = 0; i < powAsString.length(); i++) {

			if(powAsString.substring(i, i+1).equals(".")){
				break;
			}
			
			sum+= Integer.parseInt(powAsString.substring(i, i+1));
			
		}
		
		return sum;
	}

	private static BigInteger getPow(int exp) {

		
		BigInteger pow;
		
		if(exp>LIMIT){
			
			pow = TWO_POW_1000;
			
			int loop = exp/LIMIT;
			
			for (int i = 0; i < loop-1; i++) {

				pow = pow.multiply(TWO_POW_1000);
				
			}
			
			pow = pow.multiply(new BigDecimal(Math.pow(2, exp%LIMIT)).toBigInteger());
			
		}else{
			
			pow = new BigDecimal(Math.pow(2, exp)).toBigInteger();
		}
		
		return pow;
	}

}
