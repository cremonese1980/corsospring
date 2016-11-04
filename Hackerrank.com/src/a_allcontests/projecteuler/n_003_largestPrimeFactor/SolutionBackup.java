package a_allcontests.projecteuler.n_003_largestPrimeFactor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionBackup {
	
	private static final Map<Long, Long> SOLUTION_MAP = new HashMap<Long, Long>();
	private static final Map<Long, Long> PRIME_MAP = new HashMap<Long, Long>();

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
        
        	long n = scanner.nextLong();
        	
        	System.out.println(getSolution(n));
        }
        
        scanner.close();
        
    }
    
    
	private static long getSolution(long n) {
		
		return largestPrimeFactor(n, 2, 1, new ArrayList<Long>());
	}



	private static long largestPrimeFactor(long n, long divisor, long max, List<Long> divisorList){
		
		if(n==1){
			return max;
		
		}
		else if(n%divisor == 0){
			divisorList.add(divisor);
			return largestPrimeFactor(n/divisor, divisor, divisor>max ? divisor : max, divisorList);
		}else{
			return largestPrimeFactor(n, getNextDivisor(divisor+1, divisorList, n), max, divisorList);
		}
		
		
	}

	private static long getNextDivisor(long divisor, List<Long> divisorList, long n) {

		
		long nextDivisor = n;
		
		for (long i = divisor; i < n/2; i++) {
			
			boolean isModule = false;

			for (Long currentDivisor : divisorList) {
				
				if(i%currentDivisor==0){
					
					isModule = true;
					break;
				}
			}
			
			if(!isModule){
				nextDivisor = i;
				break;
			}
			
			
		}
		
		return nextDivisor;
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
