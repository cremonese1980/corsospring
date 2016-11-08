package a_allcontests.projecteuler.n_160_factorial_trailing_digits;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionBackup1 {
	
	private static final BigInteger ZERO = new BigInteger(String.valueOf("0"));
	private static final BigInteger ONE = new BigInteger(String.valueOf("1"));
	private static final BigInteger TWO = new BigInteger(String.valueOf("2"));
	private static final BigInteger TEN = new BigInteger(String.valueOf("10"));
	private static final BigInteger HUNDRED_TOUSAND = new BigInteger(String.valueOf("100000"));
	
	private static final int LIMIT = 300000;
	
	private static Map<String, List<Integer>> repetitionMap;

    public static void main(String[] args) {
    	
    	printData();
    	
//        Scanner scanner = new Scanner(System.in);
//        
//        int base = scanner.nextInt();
//        int testNumber = scanner.nextInt();
//        
//        
//        for(int a0 = 0; a0 < testNumber; a0++){
//        	
//            String stringNumber = scanner.next();
//            
//            System.out.println(getSolution(new BigInteger(stringNumber)));
//        }
//        
//        scanner.close();
    }

	private static void printData() {
		
		repetitionMap = new LinkedHashMap<String, List<Integer>>();
		
		
		for (int i = 200001; i <= LIMIT; i++) {
			
//			long t0 = System.currentTimeMillis();
//			long t = System.currentTimeMillis()-t0;			
//			System.out.println("factorial " + t + " ms");
			
//			t0 = System.currentTimeMillis();
			BigInteger otherFactorial = otherFactorial(new BigInteger(String.valueOf(i)));
//			t = System.currentTimeMillis()-t0;
//			System.out.println("other factorial " + t + " ms");
			
			String firstFactorialString = leftPad(otherFactorial.toString());
			
			if(repetitionMap.get(firstFactorialString)==null){
				
				List<Integer> numberList = new LinkedList<Integer>();
				repetitionMap.put(firstFactorialString, numberList);
				
			}else{
				repetitionMap.get(firstFactorialString).add(i);
			}
			
//			System.out.println(i +  "\tcomputed= "+ otherFactorial);
			
			if(i%1000==0){
				System.out.println("cicle " + i + "/" + LIMIT + " = " + ((double)i*100.0/((double)LIMIT)) + "%");
			}
			
		}
		
		
		printRepetitionMap();
		
		
	}
	
	private static void printRepetitionMap() {
		
		System.out.println("Repetition size " + repetitionMap.keySet().size());

		for (String lastDigits : repetitionMap.keySet()) {
			
			if(repetitionMap.get(lastDigits).size()>1){
				
				System.out.println("========================================");
				System.out.print(lastDigits + ": ");
				
				for (Integer number : repetitionMap.get(lastDigits)) {
					
					System.out.print(number);
					if(repetitionMap.get(lastDigits).indexOf(number)!=repetitionMap.get(lastDigits).size()-1){
						System.out.print(", ");
					}
					
				}
				
				System.out.println("\n========================================");
				
				
			}else{
				System.out.println("================SINGLE========================");
				System.out.print(lastDigits + ": ");
				
				for (Integer number : repetitionMap.get(lastDigits)) {
					
					System.out.print(number);
					
				}
				
				System.out.println("\n====================SINGLE====================");
			}
			
		}
		
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
	
	private static BigInteger otherFactorial2(BigInteger n, BigInteger firstFactorial) {
		
		String firstFactorialString = leftPad(firstFactorial.toString());
		
		BigInteger result = BigInteger.ONE;
		
		boolean finish = false;
		
		while(!finish){
			
			if(n.equals(BigInteger.ONE)){
				finish = true;
			}else{
				
				BigInteger normalizedN = normalizeResult(n);
				
				result = normalizedN.multiply(result);
				
				if(n.compareTo(TWO)>0 && result.toString().endsWith(firstFactorialString)){
					
					System.out.println("n= " + n + ", diff= " + (LIMIT-n.intValue()) + ", result = " + result);
				}
				
				result = normalizeResult(result);
				
				n = n.subtract(BigInteger.ONE);
			}
			
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
