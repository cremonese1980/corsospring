package a_allcontests.projecteuler.n_008_LargestProductInSeries;

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
            int k = in.nextInt();
            
            String num = in.next();
            
            int solution = getSolution(k, num);
            
            System.out.println(solution);
            
            
        }
        
        in.close();
    }

	private static int getSolution(int k, String num) {

		int max = 0;
		
		for (int i = 0; i <= num.length() - k; i++) {

			int currentProduct = 1;
			
			for (int j = i; j < i+k; j++) {

				if(num.charAt(j)=='0'){
					currentProduct = 0;
					break;
				}
				currentProduct*= Integer.parseInt("" + num.charAt(j));
				
				
			}
			
			if(currentProduct> max){
				max = currentProduct;
			}
			
		}
		
		return max;
	}
}
