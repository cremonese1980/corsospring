package alldomains.algorithms.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        
        int count=1;
        
        String originalString = in.next();
        
        for (int i = 0; i < originalString.length(); i++) {
			String string = String.valueOf(originalString.charAt(i));
			
			if(string.toUpperCase().equals(string)){
				count++;
			}
			
			
		}
        
        System.out.println(count);
    }
}
