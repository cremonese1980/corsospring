package a_allcontests.projecteuler.n_018_MaximumpathsumI;

import java.util.Scanner;

public class Solution {

	
	private static int maxSum;
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {

			int lines = scanner.nextInt();
			
			int[][] originalData = new int[lines][lines];
			
			for (int line = 0; line < lines; line++) {
				
				for (int numIndex = 0; numIndex < line +1; numIndex++) {
					
					int currInt = scanner.nextInt();

					originalData[line][numIndex] = currInt;
					
				}
				
			}
			
			checkMaxSum(originalData, 0, 0, 0);
			System.out.println(maxSum);
			maxSum = 0;
			
		}
		
		scanner.close();
		
	}

	private static void checkMaxSum(int[][] data, int rowRoot, int colRoot, int partialSum) {

		partialSum+= data[rowRoot][colRoot];
		
		if(rowRoot == data.length-1){
			
			if(partialSum>maxSum){
				maxSum = partialSum;
			}
			
			return;
		}
		
		checkMaxSum(data, rowRoot+1, colRoot, partialSum);
			
		checkMaxSum(data, rowRoot+1, colRoot+1, partialSum);
			
	}

}
