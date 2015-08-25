package diagonaldifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			
			final int size = Integer.parseInt(br.readLine());
			final int[][] matrix = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				matrix[i] = getMatrixLine(br.readLine(), size);
			}
			
			int sumD1 = 0;
			int sumD2 = 0;
			
			for (int i = 0; i < size; i++) {
				
				sumD1+= matrix[i][i];
				sumD2+= matrix[size-1-i][i];
			}
			
			final int res = sumD1>=sumD2 ? sumD1-sumD2 : sumD2-sumD1;
			
			System.out.println(res);
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static int[] getMatrixLine(String readLine, int size) {
		
		int[] matrixLine = new int[size];
		String[] line = readLine.split(" ");
		for (int i = 0; i < line.length; i++) {
			matrixLine[i] = Integer.parseInt(line[i]);
		}
		
		return matrixLine;
	}

}


