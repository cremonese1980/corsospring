package a_allcontests.projecteuler.n_010_summation_of_primes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static Map<Integer, Long> PRIME_MAP_SUM;
	private static final int MAX_N = 1002001;
	
	private static int currentMaxN = 3;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        buildPrimeMap();        
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            long solution = getSolution(n);
            
            System.out.println(solution);
        }
        
        in.close();
    }
    
    
    
    
    private static long getSolution(int n) {

    	if(n==1){
    		return n;
    	}
    	
    	return getPrimeLessOrEqualN(n);
	}




	private static long getPrimeLessOrEqualN(int n){

		long sum = 0;
    	boolean found = false;
    	
    	while(!found){
    		
    		if(PRIME_MAP_SUM.get(n) == null){
    			n--;
    		}else{
    			sum = PRIME_MAP_SUM.get(n);
    			found = true;
    		}
    		
    	}
    	
    	return sum;
    	
    }
    
    private static void buildPrimeMap() {

		PRIME_MAP_SUM = new LinkedHashMap<Integer, Long>();
		
		PRIME_MAP_SUM.put(2, 2L);
		
		int lastPrime = 2;
    	
    	for (int i = currentMaxN; i <= MAX_N; i = i+2) {
			
    		if(isPrime(i)){
    			PRIME_MAP_SUM.put(i, i+(PRIME_MAP_SUM.get(lastPrime)));
    			lastPrime = i;
    		}
    		
		}
		
	}
    
    private static boolean isPrime(long n) {
		
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    
	    return true;
	}
}
