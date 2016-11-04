package a_allcontests.projecteuler.n_003_largestPrimeFactor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static final Map<Long, Long> PRIME_MAP = new LinkedHashMap<Long, Long>();
	
	private static final int MAX_DIVISOR = 1500000;

    public static void main(String[] args) {
    	
    	PRIME_MAP.put(1L, 2L);
    	PRIME_MAP.put(2L, 3L);
    	long previousPrime = 2;
    	
    	for (long i = 3; i <= MAX_DIVISOR; i = i+2) {
			
    		if(isPrime(i)){
    			PRIME_MAP.put(previousPrime, i);
    			previousPrime = i;
    			
    		}
    		
		}
    	
    	
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
        
        	long n = scanner.nextLong();
        	
        	System.out.println(getSolution2(n));
        }
        
        scanner.close();
        
    }
    
    private static long getSolution2(long n) {
    	
    	if(PRIME_MAP.keySet().contains(n)){
    		return n;
    	}
    	if(isLargePrime(n)){
    		return n;
    	}
    	
    	boolean found = false;
    	
    	long largest = 0;
    	long currentN = n;
    	
    		
		for (Long currentPrime : PRIME_MAP.keySet()) {
			
			if(currentPrime.equals(1L)){
				continue;
			}
			
			boolean divisible = currentN%currentPrime==0 ? true: false;
			
			while(divisible){
				
				if(currentN/currentPrime!=1){
					
					currentN = currentN/currentPrime;
					divisible  = currentN%currentPrime==0 ? true: false;
					
				}else{
					
					return currentN;
					
				}
				
				
				
				
			}
			
		}  		
    		
    	
    	
    	return currentN;
    	
		
//		long largest = largestPrimeFactor(n, 2, 1);
		
	}
    
    private static long largestPrimeFactor(long n, long divisor, long max){
    	
    	if(n==1){
			return max;
		
		}
		else if(n%divisor == 0){
			return largestPrimeFactor(n/divisor, divisor, divisor>max ? divisor : max);
		}else{
			Long nextDivisor = getNextDivisor(divisor, n);
			
			if(nextDivisor!=null){
				return largestPrimeFactor(n, nextDivisor, max);
				
			}else{
				return n;
			}
		}
    	
    }
    
    private static long getNextDivisor(long divisor , long n) {

		return PRIME_MAP.get(divisor);
	}
    		

	private static long getSolution(long n) {
		
		if(isLargePrime(n)){
			return n;
		}
		
		return largestPrimeFactor(n, 2, 1, new ArrayList<Long>());
	}



	private static boolean isLargePrime(long n) {

		for (Long currentPrime : PRIME_MAP.keySet()) {
			
			if(currentPrime!=1 && n%currentPrime == 0){
				
				return false;
			}
			
		}
		
		return true;
	}


	private static long largestPrimeFactor(long n, long divisor, long max, List<Long> divisorList){
		
		if(n==1){
			return max;
		
		}
		else if(n%divisor == 0){
			divisorList.add(divisor);
			return largestPrimeFactor(n/divisor, divisor, divisor>max ? divisor : max, divisorList);
		}else{
			Long nextDivisor = getNextDivisor(divisor, divisorList, n);
			
			if(nextDivisor!=null){
				return largestPrimeFactor(n, nextDivisor, max, divisorList);
				
			}else{
				return n;
			}
		}
		
		
	}

	private static long getNextDivisor(long divisor, List<Long> divisorList, long n) {

		return PRIME_MAP.get(divisor);
	}


	private static boolean isPrime(long n) {
		
		if(PRIME_MAP.get(n)!=null){
			return true; 
		}
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    PRIME_MAP.put(new Long(n), new Long(1L));
	    
	    return true;
	}
}
