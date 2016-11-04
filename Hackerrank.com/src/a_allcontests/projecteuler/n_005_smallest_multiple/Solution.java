package a_allcontests.projecteuler.n_005_smallest_multiple;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static final int MAX_N = 40;
	
	private static List<Integer> PRIME_MAP;
	private static Map<Integer, Number> NUMBER_MAP;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        
        initData();
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            System.out.println(getSolution(n));
            
        }
        
        in.close();
    }

    
    private static long getSolution(int n) {

    	
    	Number number = NUMBER_MAP.get(n);

    	long result = number.getPrimeProduct();
    	
//    	if(result%n==0){
//    		return result;
//    	}
    	
    	for (Integer nonPrime : number.getNonPrimeList()) {
			
    		if(result%nonPrime==0){
    			continue;
    		}
    		
    		
    		boolean found = false;
    		
    		while(!found){
    			
    			int minPrimeDivisor = getMinPrimeDivisor(nonPrime, number.getPrimeList());
    			
    			result*= minPrimeDivisor;
    			
    			found = result%nonPrime == 0 ? true : false;
    			
    		}
    		
		}
    	
		
    	
    	return result;
	}
    
    
	private static int getMinPrimeDivisor(Integer nonPrime, List<Integer> primeList) {

		int result = nonPrime;
		
		for (Integer prime : primeList) {
			
			if(prime == 1){
				continue;
			}
			
			if(result < prime){
				break;
			}
			boolean divisible = result%prime==0 && result/prime!=1; 
			while(divisible){
				result/= prime;
				divisible = result%prime==0 && result/prime!=1;
			}
			
		}
		
		return result;
	}


	private static void initData() {

		buildPrimeMap();
		
		buildNumbers();
	}


	private static void buildPrimeMap() {

		PRIME_MAP = new LinkedList<Integer>();
		
		PRIME_MAP.add(1);
		PRIME_MAP.add(2);
    	
    	for (int i = 3; i <= MAX_N; i = i+2) {
			
    		if(isPrime(i)){
    			PRIME_MAP.add(i);
    			
    		}
    		
		}
		
	}

	private static void buildNumbers() {

		NUMBER_MAP = new LinkedHashMap<Integer, Number>();
		
		for (int i = 1; i <= 40; i++) {

			List<Integer> primeList = getPrimeListBelowN(i);
			
			Number currentNumber = new Number(i, primeList);
			
			NUMBER_MAP.put(i, currentNumber);
		}
		
	}
	
	
	private static List<Integer> getPrimeListBelowN(int i) {
		
		List<Integer> primeList = new LinkedList<Integer>();
		
		for (Integer prime : PRIME_MAP) {
			
			if(prime>i){
				break;
			}else{
				primeList.add(prime);
			}
		}
		
		return primeList;
	}


	private static boolean isPrime(long n) {
		
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    
	    return true;
	}
	
	
	static class Number{
		
		private int n;
		private long primeProduct;
		private List<Integer> primeList;
		private List<Integer> nonPrimeList;

		public Number(int n, List<Integer> primeList) {

			this.n = n;
			this.primeList = primeList;
			
			long product = 1;
			
			for (Integer prime : primeList) {
				
				product*= prime;
				
			}
			
			primeProduct = product;
			
			nonPrimeList = new LinkedList<Integer>();
			for (int i = 1; i <= n; i++) {

				if(!primeList.contains(i)){
					nonPrimeList.add(i);
				}
				
			}
			
		}

		public int getN() {
			return n;
		}

		public long getPrimeProduct() {
			return primeProduct;
		}

		public List<Integer> getPrimeList() {
			return primeList;
		}

		public List<Integer> getNonPrimeList() {
			return nonPrimeList;
		}
		
	}
}

