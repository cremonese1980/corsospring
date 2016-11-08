package a_allcontests.projecteuler.n_007_10001stprime;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static List<Integer> PRIME_MAP;
	private static final int MAX_N = 10000;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        buildPrimeMap();
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            int solution = getSolution(n);
            
            System.out.println(solution);
            
        }
        
        in.close();
    }
    
    
    private static int getSolution(int n) {

    	
    	return PRIME_MAP.get(n);
	}


	private static void buildPrimeMap() {

		PRIME_MAP = new LinkedList<Integer>();
		
		PRIME_MAP.add(1);
		PRIME_MAP.add(2);
    	
    	for (int i = 3; PRIME_MAP.size() <= MAX_N + 1; i = i+2) {
			
    		if(isPrime(i)){
    			PRIME_MAP.add(i);
    			
    		}
    		
		}
		
	}
    
    private static boolean isPrime(long n) {
		
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    
	    return true;
	}
}
