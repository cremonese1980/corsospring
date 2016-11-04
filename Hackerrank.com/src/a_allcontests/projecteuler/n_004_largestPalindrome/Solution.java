package a_allcontests.projecteuler.n_004_largestPalindrome;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static Map<Integer, Integer> palindromeMap;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        
        initData();
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            System.out.println(findLargestPalindromeByN(n));
        }
        in.close();
    }

	private static Integer findLargestPalindromeByN(int n) {

		Integer largest = 101101;
		
		for (Integer currentPalindrome : palindromeMap.keySet()) {
			
			if(currentPalindrome>=n){
				break;
			}
			
			if(currentPalindrome>= largest){
				largest = currentPalindrome;
			}
			
		}
		
		return largest;
	}

	private static void initData() {
		
		palindromeMap = new LinkedHashMap<Integer, Integer>();
		
		Integer currentPalindrome;

		for (int lefDigit = 1; lefDigit <= 9; lefDigit++) {
			
			for (int centralDigit = 0; centralDigit <= 9; centralDigit++) {
				
				for (int rightDigit = 0; rightDigit <= 9; rightDigit++) {
					
					
					currentPalindrome = Integer.parseInt(lefDigit + "" + centralDigit + "" + rightDigit + "" + rightDigit + "" + centralDigit + "" + lefDigit);
					
					Integer divisor = hasThreeDigitDivisor(currentPalindrome); 
					
					if(divisor!=null){
						
						palindromeMap.put(currentPalindrome, divisor);
					}
					
					
				}
				
				
			}
			
		}
		
	}

	private static Integer hasThreeDigitDivisor(Integer currentPalindrome) {
		
		for (int divisor = 100; divisor <= 999; divisor++) {
			
			if(currentPalindrome.intValue()%divisor == 0){
				
				int result = currentPalindrome.intValue()/divisor;
		
				if(result >= 100 && result <= 999){

					return divisor;
					
				}
				
			}
			
		}
		
		return null;
	}
    
    
    
}
