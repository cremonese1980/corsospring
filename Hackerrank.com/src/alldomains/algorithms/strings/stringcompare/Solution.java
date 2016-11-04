package alldomains.algorithms.strings.stringcompare;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        String inputString = sc.next();
        int lenght = sc.nextInt();
        
        sc.close();
        
        String minString = null;
        String maxString = null ;
        
        for (int i = 0; i <= inputString.length()-lenght; i++) {
			
        	String currentSubstring = inputString.substring(i, i+lenght);
        	
        	minString = minString == null || currentSubstring.compareTo(minString)<0? currentSubstring : minString;
        	
        	maxString = maxString == null || currentSubstring.compareTo(maxString)>0? currentSubstring : maxString; 
			
		}
        
        System.out.println(minString);
        
        System.out.println(maxString);
        
        
        
    }
}
