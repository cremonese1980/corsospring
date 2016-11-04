package alldomains.algorithms.strings.stringreverse;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String inputString =sc.next();
        
        boolean palindrome = true;

        for (int i = 0; i <= inputString.length()/2; i++) {
        	
        	if(inputString.charAt(i)!= inputString.charAt(inputString.length()-1-i)){
        		
        		palindrome = false;
        		break;
        	}
        	
			
		}
        
        if(palindrome){
        	System.out.println("Yes");
        }else{
        	System.out.println("No");
        }
        
    }
}
