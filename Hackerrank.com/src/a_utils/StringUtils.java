package a_utils;

import java.util.Set;
import java.util.TreeSet;

public class StringUtils {
	
	private static Set<String> getPermutations(String originalRemaining) {

		if(originalRemaining.length()==1){
			Set<String> permutations = new TreeSet<String>();
			permutations.add(originalRemaining);
			return permutations;
		}
		
		if(originalRemaining.length()==2){
			
			Set<String> permutations = new TreeSet<String>();
			permutations.add(originalRemaining);
			permutations.add(originalRemaining.substring(1) + originalRemaining.substring(0, 1));
			
			return permutations;
			
			
		}else{
			
			Set<String> permutations = new TreeSet<String>();;
			
			for (int currCharIndex = 0; currCharIndex < originalRemaining.length(); currCharIndex++) {
				
				String remaining = originalRemaining.substring(0, originalRemaining.indexOf(originalRemaining.charAt(currCharIndex)));
				
				remaining+= currCharIndex<originalRemaining.length()-1 ? originalRemaining.substring(originalRemaining.indexOf(originalRemaining.charAt(currCharIndex))+1) : "";
				
				String currChar = String.valueOf(originalRemaining.charAt(currCharIndex));
				
				Set<String> oldPermutations = getPermutations(remaining);
				
				for (String string : oldPermutations) {
					
					permutations.add(currChar +string);
				}
					
				
				
			}
			return permutations;
			
		}
		
	}

}
