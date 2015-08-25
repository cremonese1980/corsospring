package averybigsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			final int n = Integer.parseInt(br.readLine());
			final String input = br.readLine();
			final String[] splittedInput = input.split(" ");
			BigDecimal result = new BigDecimal(0);
			
			for (int i = 0; i < n; i++) {
				
				result = result.add(new BigDecimal(splittedInput[i]));
				
			}
			
			System.out.println(result.longValue());
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
}


