package alldomains.algorithms.strings.marsexploration;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        
        int count=0;
        
        String originalString = scanner.next();
        
        scanner.close();
        
        
        for (int i = 0; i < originalString.length(); i++) {
			
        	String currentChar = String.valueOf(originalString.charAt(i));
			
			count+= ((i%3==0 || i%3==2) && !currentChar.equals("S"))
					|| i%3== 1 && !currentChar.equals("O") ? 1:0;
			
			
		}
        
        System.out.println(count);
    }
}
