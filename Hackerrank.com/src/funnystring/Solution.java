package funnystring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static final String FUNNY = "Funny";
	private static final String NOT_FUNNY = "Not Funny";
	
	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			final int t = Integer.parseInt(br.readLine());
			
			String input;
			
			for (int i = 0; i < t; i++) {
				input = br.readLine();
				System.out.println(run(input));
				
			}
			
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String run(String input) {
		
		int length = input.length();
		
		for (int i = 1; i < length; i++) {
			
			int d1 = ((int)input.charAt(i)) - ((int)input.charAt(i-1));
			int d2 = ((int)input.charAt(length-i)) - ((int)input.charAt(length-i -1));
			if(Math.abs(d1)!=Math.abs(d2)){
				return NOT_FUNNY;
			}
			
		}
		
		
		return FUNNY;
	}
	
}


