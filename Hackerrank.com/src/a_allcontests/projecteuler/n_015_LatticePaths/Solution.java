package a_allcontests.projecteuler.n_015_LatticePaths;

import java.util.Scanner;

public class Solution {
	
	private static final int MODULE = 1000000007;
	private static final int MAX = 500;
	
	private static long[][] data;
	
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		buildData();
		
		for (int i = 0; i < t; i++) {
			
			
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			System.out.println(data[n][m]);
			
		}
		
		
		scanner.close();
		
	}

	private static void buildData() {

		data = new long[MAX+1][MAX+1];
		
		for (int n = 1; n <= MAX; n++) {
			
			for (int m = 1; m <= MAX; m++) {

				
				if(n == 1){
					
					data[n][m] = 1 + m;
				
				}else if(m==1){
					
					data[n][m] = 1 + n;
				}else{
					
					data[n][m] = ((data[n-1][m]) + (data[n][m-1]))%MODULE; 
				}
				
			}
			
			
		}
		
	}


}
