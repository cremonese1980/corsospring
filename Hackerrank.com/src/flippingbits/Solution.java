package flippingbits;

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
			
			
				
			List<Long> longList = new ArrayList<Long>();
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				
				longList.add(flip(Long.parseLong(br.readLine())));
				
			}
			
			for (Long currInt : longList) {
				System.out.println(currInt);
			}
			
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static long flip(long integer) {

		String binaryString = Long.toBinaryString(integer);
		binaryString = fillZeros(binaryString);
		StringBuffer binaryFlippedString = new StringBuffer();
		
		for (int i = 0; i < binaryString.length(); i++) {
			if(binaryString.charAt(i)=='0'){
				binaryFlippedString.append("1");
			}else{
				binaryFlippedString.append("0");
			}
		}
		
		return binaryToInteger(binaryFlippedString.toString());
	}

	private static String fillZeros(String binaryString) {
		
		int countZeros = 32- binaryString.length();
		
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < countZeros; i++) {
			buffer.append("0");
		}
		
		return buffer.toString() + binaryString;
	}
	
	private static long binaryToInteger(String binary) {
		
		return Long.parseLong(binary, 2);
		
	}
	
	
}


