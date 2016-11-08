package a_allcontests.projecteuler.n_160_factorial_trailing_digits;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionBackup2 {
	
	private static final BigInteger ZERO = new BigInteger(String.valueOf("0"));
	private static final BigInteger ONE = new BigInteger(String.valueOf("1"));
	private static final BigInteger TWO = new BigInteger(String.valueOf("2"));
	private static final BigInteger TEN = new BigInteger(String.valueOf("10"));
	private static final BigInteger HUNDRED_TOUSAND = new BigInteger(String.valueOf("100000"));
	
	private static final int LIMIT = 200;
	
	private static Map<BigInteger, BigInteger> coincidenceMap;

    public static void main(String[] args) {
    	
    	printData();
    	
    }

	private static void printData() {
		
		
		coincidenceMap = new LinkedHashMap<BigInteger, BigInteger>();
		
		BigInteger firstFactorial = null;
		
		for (int i = 1; i <= LIMIT; i++) {
			
			firstFactorial = otherFactorial(new BigInteger(String.valueOf(i)));
			
//			System.out.println("n = " + i + ", last five = " + firstFactorial );
//			BigInteger otherFactorial = otherFactorial2(new BigInteger(String.valueOf(i)), firstFactorial, new BigInteger(String.valueOf(i)));
			
			BigInteger otherFactorial = factorial(new BigInteger(String.valueOf(i)));
			
//			System.out.println("\n____________________________________\n");
			System.out.println(i + ":\t5 digits= " + firstFactorial + ", fact= " + otherFactorial);
			
		}
		
		System.out.println("Finish");
		
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
	
	private static BigInteger otherFactorial2(BigInteger n, BigInteger firstFactorial, BigInteger originalN) {
		
		String firstFactorialString = leftPad(firstFactorial.toString());
		
		BigInteger result = BigInteger.ONE;
		
		boolean finish = false;
		
		boolean foundLimit = false;
		
		while(!finish){
			
			if(n.equals(BigInteger.ONE)){
				finish = true;
			}else{
				
				BigInteger normalizedN = normalizeResult(n);
				
				result = normalizedN.multiply(result);
				
				if(!foundLimit && n.compareTo(TWO)>0 && result.toString().endsWith(firstFactorialString)){
					
					foundLimit = true;
					
					if(coincidenceMap.get(n)==null){
						coincidenceMap.put(n, originalN);
//						System.out.println("Original n= " + originalN + ", n= " + (n) + ", result = " + result);
					}
					
				}
				
				result = normalizeResult(result);
				
				n = n.subtract(BigInteger.ONE);
			}
			
		}
		
		if(!foundLimit){
//			System.out.println("No coincidence found");
		}
		
		return result;
		
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
