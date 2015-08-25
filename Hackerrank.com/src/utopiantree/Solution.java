package utopiantree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			
			final int t = Integer.parseInt(br.readLine());
			int nCycles;
			int size = 1;
			
			for (int i = 0; i < t; i++) {
				
				size = 1;
				nCycles = Integer.parseInt(br.readLine());
				
				for(int j = 1; j <= nCycles; j++){
					
					if(j%2==0){
						size = summerGrowth(size);
					}else{
						size = springGrowth(size);
					}
				}
				
				System.out.println(size);
				
			}
			
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
	private static int springGrowth(final int size){
		return size*2;
	}
	private static int summerGrowth(final int size){
		return size + 1;
	}
	
}


