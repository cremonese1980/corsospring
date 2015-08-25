package pangrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	

	public static void main(String[] args) {
		
		
		
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			
			final String phrase = br.readLine().toLowerCase();
			
			final String res = isPangram(phrase);
			
			System.out.println(res);
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String isPangram(String phrase) {
		
		String[] ALPHABET = {"a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","w","z"};
		List<String> letterList = new ArrayList<String>();
		
		for (int i = 0; i < ALPHABET.length; i++) {
			letterList.add(ALPHABET[i]);
		}
		
		char[] phraseArray = phrase.toCharArray(); 
		
		for (int i = 0; i < phraseArray.length; i++) {
			if(letterList.contains(Character.toString(phraseArray[i]))){
				letterList.remove(Character.toString(phraseArray[i]));
			}
			if(letterList.size()==0){
				return "pangram";
			}
		}
		
		return "not pangram";
	}


}


