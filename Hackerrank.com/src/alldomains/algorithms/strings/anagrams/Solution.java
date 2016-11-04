package alldomains.algorithms.strings.anagrams;

import java.io.*;
import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class Solution {
	
	
	
    static boolean isAnagram(String a, String b) {
        
    	if(a.length()!=b.length()){
    		return false;
    	}
    	
    	int [] aComposition = new int[50];
    	int [] bComposition = new int[50];
    	
    	a = a.toLowerCase();
    	b = b.toLowerCase();

    	boolean anagram = true;
    	
    	
    	
    	for (int i = 0; i < a.length(); i++) {

    		aComposition[Character.getNumericValue(a.charAt(i))]++;
    		bComposition[Character.getNumericValue(b.charAt(i))]++;
    		
    		
		}
    	
    	for (int i = 0; i < aComposition.length; i++) {
    		
    		if(aComposition[i]!= bComposition[i]){
    			anagram = false;
    			break;
    		}
    		
    	}
    	
    	
    	return anagram;
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	public static void main(String[] args) {
	    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        
        
    }
}
