package simplearraysum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			double t = Double.parseDouble(br.readLine());
			String [] inputArrayString = br.readLine().split(" ");
			
			double positiveSum = 0;
			double negativeSum = 0;
			double zeroSum = 0;
			
			for (int i = 0; i < inputArrayString.length; i++) {
				
				long currNum = Long.parseLong(inputArrayString[i]);
				
				if(currNum>0){
					positiveSum++;
				}
				if(currNum<0){
					negativeSum++;
				}
				if(currNum==0){
					zeroSum++;
				}
				
				
			}
			
			double psum = positiveSum/t;
			double nsum = negativeSum/t;
			double zsum = zeroSum/t;
			
			String pattern = "0.000";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			
			System.out.println(decimalFormat.format(Math.round(psum * 1000.0) / 1000.0));
			System.out.println(decimalFormat.format(Math.round(nsum * 1000.0) / 1000.0));
			System.out.println(decimalFormat.format(Math.round(zsum * 1000.0) / 1000.0));
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
}


