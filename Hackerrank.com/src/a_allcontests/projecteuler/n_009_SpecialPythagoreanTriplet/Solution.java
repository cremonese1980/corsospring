package a_allcontests.projecteuler.n_009_SpecialPythagoreanTriplet;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static final int N_MAX = 3000;
	
	private static Map<Integer, Integer> SOLUTION_MAP;
	
	
    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        initData();
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++){
            
        	int n = in.nextInt();
        	
        	int solution = getSolution(n);
        	
        	
        	System.out.println(solution);
        	
        		
        }
        
        in.close();
    }

	private static int getSolution(int n) {

		return SOLUTION_MAP.get(n)!=null ? SOLUTION_MAP.get(n) : -1 ;
	}

	private static void initData() {
		
		SOLUTION_MAP = new HashMap<Integer, Integer>();

		for (int i = 12; i <= N_MAX; i++) {

			SOLUTION_MAP.put(i, getSolutionByN(i));
			
		}
		
	}

	private static int getSolutionByN(int n) {


		if(n<12){
			return -1;
		}
		
		int max = -1;
		
		for (int a = 1; a < n-6; a++) {
			
			int aq = a*a;
			
			for (int b = a+1; b < n-6; b++) {
				
				
				int c = n- (a+b);
				
				if(c<=0){
					break;
				}
				
				if(aq + b*b == c*c){
					
					max = Math.max(max, a*b*c);
					
				}
				
				
			}
			
			
		}
		
		return max;
	}
}
