package alldomains.algorithms.implementation.repeatestring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        
        BigInteger countA=BigInteger.ZERO;
        BigInteger count= BigInteger.ZERO;
        
        String originalString = scanner.nextLine();
        
        BigInteger n = new BigInteger(scanner.nextLine());
        BigInteger stringLength = new BigInteger(String.valueOf(originalString.length()));
        
        scanner.close();
        
        BigInteger wholeStringCount = n.divide(stringLength) ;
        int lastPartialIndex = n.mod(stringLength).intValue();
        
        String lastString = originalString.substring(0, lastPartialIndex);
        
        for (int i = 0; i < originalString.length(); i++) {
			
        	String currentChar = String.valueOf(originalString.charAt(i));
			
			countA= currentChar.equals("a") ? countA.add(BigInteger.ONE):countA.add(BigInteger.ZERO);
			
		}
        
        for (int i = 0; i < lastString.length(); i++) {
			
        	String currentChar = String.valueOf(lastString.charAt(i));
			
			count= currentChar.equals("a") ? count.add(BigInteger.ONE):count.add(BigInteger.ZERO);
			
		}
        
        count = count.add(countA.multiply(wholeStringCount));
        
        System.out.println(count);
    }
}
