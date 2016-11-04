package alldomains.algorithms.implementation.divisibìlesumpair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static final int MAX_VALUE = 6;

	public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        int sequenceSize = scanner.nextInt();
        int k = scanner.nextInt();
        
        int count = 0;
        
        int currentNumber;
        
        long[][] currentSituation = new long[2*MAX_VALUE +1][2*MAX_VALUE+1];
        long[][] nextSituation = new long[2*MAX_VALUE +1][2*MAX_VALUE+1];
        
        for (int i = 0; i < sequenceSize; i++) {
        	
        	currentNumber = scanner.nextInt();        	
        
        	System.arraycopy(currentSituation[currentNumber], 0, nextSituation[currentNumber], 0, nextSituation.length);
        	
        	for (int currentSum = 2; currentSum <= 2*MAX_VALUE; currentSum++) {
        		
        		int complementarNumber = currentSum - currentNumber;
        		
        		if (complementarNumber <= 0 || complementarNumber > MAX_VALUE ) continue;
        		
        		
        		
        		if(currentSum%k==0){
        			
        			nextSituation[currentNumber][currentSum]++;
        			nextSituation[currentNumber][currentSum] += currentSituation[complementarNumber][currentSum];
        			count += 1*currentSituation[complementarNumber][currentSum];
        		}
        		
        		
        	}
        	System.arraycopy(nextSituation[currentNumber], 0, currentSituation[currentNumber], 0, nextSituation.length);
        	
        	
        }
        
         scanner.close();
        
//        for(int a_i=0; a_i < n; a_i++){
//            
//        	a[a_i] = in.nextInt();
//            
//            for(int a_j=a_i-1 ; a_j >=0 ; a_j--){
//            	
//            	if((a[a_i] +a[a_j])%k==0){
//            		
//            		
//            		count++;
//            	}
//            	
//            }
//        }
        
        System.out.println(count);
    }
}
