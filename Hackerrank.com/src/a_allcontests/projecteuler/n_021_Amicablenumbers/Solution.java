package a_allcontests.projecteuler.n_021_Amicablenumbers;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	
	
	private static final boolean TEST = false;
	private static final int MAX_N = 100000;
	
	private static Map<Integer, Integer> divisorSumMap;
	private static Set<Integer> amicableList;

	
public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		long t0 = System.currentTimeMillis();
		
		buildData();
		
		long totalTime = System.currentTimeMillis() - t0;
		if(TEST){
			
			System.out.println(totalTime + " ms");
		}
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
					
			int n = scanner.nextInt();
			
			System.out.println(getSolution(n));
		}
		
		scanner.close();
		
		
		
		
	}

	private static int getSolution(int n) {
		
		int solution = 0;
		
		for (Integer amicable : amicableList) {
			
			if(amicable>=n){
				break;
			}
			
			solution+=amicable;
			
		}
	
		return solution;
}

	private static void buildData() {
		
		divisorSumMap = new TreeMap<Integer, Integer>();
		
		
		for (int n = 1; n <= MAX_N; n++) {
			

			buildDivisors(n);
			
		}
		
		buildAmicableList();
		
	}

	private static void buildAmicableList() {


		amicableList = new TreeSet<Integer>();
		
		for (Integer n : divisorSumMap.keySet()) {
			
			int divisorSum = divisorSumMap.get(n);
			
			if(divisorSumMap.get(divisorSum)!=null
					 && divisorSumMap.get(divisorSum).equals(n) && divisorSum!= n){
				
				amicableList.add(n);
				
			}
			
		}
		
	}

	private static void buildDivisors(int n) {

		if(n == 1){
			divisorSumMap.put(1, 1);
			return;
		}
		
		int sum = 1;
		
		for (int divisor = 2; divisor*divisor <= n; divisor++) {
			
			 if(n%divisor == 0){
				 
				int square = divisor*divisor;
				
				if(n==square){
					
					sum+= divisor;
				
				}else{
					
					sum+= divisor;
					sum+= n/divisor;
					
				}
				
			}
			
		}
		
		divisorSumMap.put(n, sum);
		
	}


}
