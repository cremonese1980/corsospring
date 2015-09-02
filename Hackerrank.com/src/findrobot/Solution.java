package findrobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			final int t = Integer.parseInt(br.readLine());
			
			
			for (int i = 0; i < t; i++) {
				
				final int n = Integer.parseInt(br.readLine());
				System.out.println(position(n));
				
			}
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String position(final int n) {


		int resto = n % 4;
		int div = n/4;
		int x=0;
		int y=0;

		switch (resto) {
		case 1:
			x = 1 + 2*div;
			y = -2*div;
			break;

		case 2:
			x = 2*div +1;
			y = (div+1)*2;
			break;
		case 3:
			x = -2*(div+1);
			y = 2*(div+1);
			break;

		case 0:
			x = -1*n/2;
			y = -1*n/2;
			break;

		}
		
		return  x + " " + y;
	}
}


