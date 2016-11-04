package a_allcontests.projecteuler.n_006_sum_square_difference;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            System.out.println(getSolution(n));
        }
        
        in.close();
    }

	private static long getSolution(int n) {

		long sumOfSquares = getSumOfSquares(n);
		long squareOfSum = getSquareOfSum(n);
		
		return Math.abs(sumOfSquares-squareOfSum);
	}

	private static long getSquareOfSum(int n) {

		long result = (n*(n+1))/2; 
		
		return result*result;
	}

	private static long getSumOfSquares(int n) {
		
		long result = 0;
		
		for (int i = 1; i <= n; i++) {

			result+= i*i;
			
		}
		
		return result;
	}
}
