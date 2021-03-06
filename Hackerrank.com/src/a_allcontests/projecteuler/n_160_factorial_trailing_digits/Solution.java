package a_allcontests.projecteuler.n_160_factorial_trailing_digits;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static final BigInteger ZERO = new BigInteger(String.valueOf("0"));
	private static final BigInteger ONE = new BigInteger(String.valueOf("1"));
	private static final BigInteger TWO = new BigInteger(String.valueOf("2"));
	private static final BigInteger TEN = new BigInteger(String.valueOf("10"));
	private static final BigInteger HUNDRED_TOUSAND = new BigInteger(String.valueOf("100000"));
	private static final BigInteger MILLION = new BigInteger(String.valueOf("1000000"));
	
	private static final int LIMIT = 1000000000;
	
	private static Map<BigInteger, BigInteger> coincidenceMap;

    public static void main(String[] args) {
    	
    	printData();
    	
    }

	private static void printData() {
		
		System.out.println("=============================================");
		System.out.printf("%-10s", "N");
		System.out.printf("%-10s", "Zeros");
		System.out.printf("%-10s", "Last 5");
		System.out.printf("%-10s", "Last 5");
		System.out.printf("%-30s%n", "Factorial");
		
		
		BigInteger firstFactorial = null;
		BigInteger otherFactorial = null;
		
		for (long i = 1; i <= LIMIT; i++) {
			
			for (long j = 1; j <= LIMIT; j++) {
				
				long test= 123456*145678;
				
				
			}
			System.out.println("Completed " + LIMIT * i);
			
		}
		
//		for (long i = LIMIT; i <= LIMIT; i++) {
//			
//			firstFactorial = null;// otherFactorial(new BigInteger(String.valueOf(i)));
//			
//			long zeros = countZeros(i);
//			String lastFive = null;//getLastFiveNonZeroDigits(firstFactorial);
//			
//			otherFactorial = otherFactorial2(new BigInteger(String.valueOf(i)));
//			
//			
//			System.out.println("=============================================");
//			System.out.printf("%-10s", i);
//			System.out.printf("%-10s", zeros);
//			System.out.printf("%-10s", lastFive);
//			System.out.printf("%-10s", otherFactorial);
//			System.out.printf("%-30s%n", firstFactorial);
//			
//			
//			
//		}
		
		System.out.println("Finish");
		
	}
	
	private static int numberLength(BigInteger firstFactorial) {
		return firstFactorial.toString().length();
	}

	private static long countZeros(long i) {
		
		long result = 0;
		
		boolean finish = false;
		long fivePower = 5;
		
		while(!finish){
			
			result+=i/fivePower;
			
			fivePower*= 5;
			
			if(fivePower>i){
				finish = true;
			}
			
		}

		return result;
		
//		return i/5 + i/25 + i/125;
	}

	private static BigInteger otherFactorial(BigInteger n) {
		
		BigInteger result = BigInteger.ONE;
		
		boolean finish = false;
		
		while(!finish){
			
			if(n.equals(BigInteger.ONE)){
				finish = true;
			}else{
				
				result = n.multiply(result);
				
				boolean tenDivisible = result.mod(TEN).equals(BigInteger.ZERO);
				
				while(tenDivisible){
					
					result = result.divide(TEN);
					tenDivisible = result.mod(TEN).equals(BigInteger.ZERO);
					
				}
				
				boolean biggerThan_100000 = result.compareTo(HUNDRED_TOUSAND)>0 ? true: false;
				
				while(biggerThan_100000){
					
					result = result.mod(HUNDRED_TOUSAND);
					biggerThan_100000 = result.compareTo(HUNDRED_TOUSAND)>0 ? true: false;
					
					
				}
				
				n = n.subtract(BigInteger.ONE);
			}
			
		}
		
		return result;
		
	}
	
	private static BigInteger otherFactorial2(BigInteger n) {
		
		BigInteger normalizedN = n.compareTo(MILLION)>0 ? MILLION : n;
		
		BigInteger result = BigInteger.ONE;
		
		boolean finish = false;
		
		
		while(!finish){
			
			if(n.equals(BigInteger.ONE)){
				finish = true;
			}else{
				
//				normalizedN = normalizeResult(n);
				
				result = normalizedN.multiply(result);
				
				result = normalizeResult(result);
				
				normalizedN = normalizedN.subtract(BigInteger.ONE);
			}
			
		}
		
		return result.mod(new BigInteger(String.valueOf("100000")));
		
	}

	private static String leftPad(String string) {
		
		int n = 5 -string.length();
		
		for (int i = 0; i < n; i++) {

			string = "0" + string;
			
		}
		
		return string;
	}

	private static BigInteger normalizeResult(BigInteger result) {
		
		boolean tenDivisible = result.mod(TEN).equals(BigInteger.ZERO);
		
		while(tenDivisible){
			
			result = result.divide(TEN);
			tenDivisible = result.mod(TEN).equals(BigInteger.ZERO);
			
		}
		
		boolean biggerThan_100000 = result.compareTo(HUNDRED_TOUSAND)>0 ? true: false;
		
		while(biggerThan_100000){
			
			result = result.mod(HUNDRED_TOUSAND);
			biggerThan_100000 = result.compareTo(HUNDRED_TOUSAND)>0 ? true: false;
			
			
		}
		
		return result;
	}

	private static String getLastFiveNonZeroDigits(BigInteger factorial){
		
		String fString = factorial.toString();
		
		int lastAddress = getFirstTrailingZeroAddress(factorial);
		
		if(lastAddress == -1){
			return "-";
		}
		lastAddress++;
		
		return fString.substring(Math.max(lastAddress-5, 0) , lastAddress);
		
		
		
	}
	
	private static int getFirstTrailingZeroAddress(BigInteger factorial) {
		
		String fString = factorial.toString();
		
		for (int i = fString.length()-1; i >= 0; i--) {

			if(fString.charAt(i) != '0'){
				return i;
			}
			
		}
		return -1;
		
	}

	private static int countZeros(BigInteger factorial) {

		int countZeros = 0;
		
		String fString = factorial.toString();
		
			for (int i = fString.length()-1; i >= 0; i--) {

				if(fString.charAt(i) == '0'){
					countZeros++;
				}else{
					break;
				}
				
			}
		
		return countZeros;
	}

	private static BigInteger getSolution(BigInteger n) {

		
		
		
		return factorial(n);
	}

	private static BigInteger factorial(BigInteger n) {
		
		BigInteger result = BigInteger.ONE;
		
		boolean finish = false;
		
		while(!finish){
			
			if(n.equals(BigInteger.ONE)){
				finish = true;
			}else{
				
				result = n.multiply(result);
				n = n.subtract(BigInteger.ONE);
			}
			
		}
		
		return result;
		
		
	}

}
