package a_allcontests.projecteuler.n_002;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger MAX_N = new BigInteger("40000000000000000");
	

	private static final Map<Long, BigInteger> FIBONACCI_MAP = new HashMap<Long, BigInteger>();
	static{
		FIBONACCI_MAP.put(1L, ONE);
		FIBONACCI_MAP.put(2L, TWO);
	}
	
	private static final Map<Long, BigInteger> SOLUTION_MAP = new HashMap<Long, BigInteger>();
	

    public static void main(String[] args) {
    	
    	
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
        	
            long n = in.nextLong();
            
            System.out.println(getSolution(n));
        }
        
        in.close();
        
    }
    

	private static BigInteger getSolution(long n) {
		
		if(SOLUTION_MAP.get(n)!=null){
			return SOLUTION_MAP.get(n);
		}

		BigInteger nBigInteger = new BigInteger(String.valueOf(n));
    	
    	BigInteger solution = ZERO;
    	BigInteger currentFibonacci;
    	
    	for (long i = 2; i < n; i++) {
			
    		currentFibonacci = fibonacci(i);
    		
    		if(currentFibonacci.compareTo(nBigInteger)>0){
    			break;
    		}
    		else if(currentFibonacci.mod(TWO).equals(ZERO)){
    			solution = solution.add(currentFibonacci);
    			SOLUTION_MAP.put(i, solution);
    		}
    		
		}
    	
    	
    	
    	return solution;
	}
	
	private static BigInteger fibonacci(long n) {
		
	    if (n == 0 || n == 1) {
	        return BigInteger.ONE;
	    }
	    if (FIBONACCI_MAP.containsKey(n)) {
	        return FIBONACCI_MAP.get(n);
	    }
	    BigInteger v = fibonacci(n - 2).add(fibonacci(n - 1));
	    FIBONACCI_MAP.put(n, v);
	    
	    return v;
	}
    

}

