package extralongfactorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			final int n = Integer.parseInt(br.readLine());
			
			BigInteger result = new BigInteger("1");
			
			for (int i = 1; i <= n; i++) {
				result = result.multiply(new BigInteger(""+i));
			}
			
			System.out.println(result);
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
}


