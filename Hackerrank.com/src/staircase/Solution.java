package staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			double n = Integer.parseInt(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				
				System.out.println(getLine(n, i));
				
			}
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String getLine(double n, int i) {
		
		StringBuffer res = new StringBuffer("");
		
		for (int j = 1; j <= n; j++) {
			if(j<=n-i){
				res.append(" ");
			}
			else{
				res.append("#");
			}
		}
		
		return res.toString() ;
	}
}


