package a_allcontests.projecteuler.n_012HighlyDivisibleTriangularNumber;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	private static final int MAX_DIVISOR = 1000;
	
	private static Map<Long, Integer> triangleDivisorsMap;
	private static int[] divisorList;
	
	
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
//        long t0 = System.currentTimeMillis();
        buildData();
//        System.out.println(System.currentTimeMillis()-t0);
        
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            long solution = getSolution(n);
            
            System.out.println(solution);
        }
        
        in.close();
    }


	private static void buildData() {

		
		triangleDivisorsMap = new TreeMap<Long, Integer>();
		
		triangleDivisorsMap.put(1L, 1);
		triangleDivisorsMap.put(3L, 2);
		
		divisorList = new int[2*MAX_DIVISOR];
		divisorList[1] = 1;
		divisorList[2] = 1;
		
		
		
		long previousTriangle = 3;
		
		boolean finish = false;
		int currentN =3;
		long currentTriangle;
		
		while(!finish){
			
			currentTriangle = previousTriangle + currentN;
			previousTriangle = currentTriangle;
			
			int divisors = getDivisors(currentTriangle);
			
			if(divisorList[divisors] == 0){
				divisorList[divisors] = 1;

				if(triangleDivisorsMap.get(currentTriangle)==null){
					
					triangleDivisorsMap.put(currentTriangle, divisors);
				}
				
				if(divisors >= MAX_DIVISOR){
					finish = true;
				}
			}
			
			
			currentN++;
			
		}
		
		
	}


	private static int getDivisors(long currentTriangle) {

		if(currentTriangle%2 != 0){
			return 1;
		}
		
		int divisor = 2;
		double sqrt = Math.sqrt(currentTriangle);
		
		for (int i = 2; i <= sqrt; i++) {
			
			if(currentTriangle%i==0){
				
				divisor = divisor+2;
			}
			if(i*i==currentTriangle){
				divisor--;
			}
		}
		
		return divisor;
	}


	private static long getSolution(int minimumDivisors) {

		minimumDivisors++;
		
		for (Long triangle : triangleDivisorsMap.keySet()) {
			
			if(triangleDivisorsMap.get(triangle).intValue()>= minimumDivisors){
				return triangle;
			}
		}
		
		return 0;
	}

	
}
