package a_allcontests.universityCodeSprint.n3_KindergartenAdventures;

import java.util.Random;
import java.util.Scanner;

public class Solution{
	
	private static final int MAX_N = 100000;
	private static final boolean TEST = false;
	private static final Random RANDOM = new Random();
	
	private static int [] solutions;
	
	private static int bestSolution = 0;
	private static int bestPosition = 0;
	private static int n;
	
	public static void main(String[] args) {
		
		long t0 = System.currentTimeMillis();
		
		Scanner scanner = new Scanner(System.in);
        
        n = TEST ? MAX_N : scanner.nextInt();
        
        solutions = new int[n*2];
        
        for(int t = 0; t < n ; t++){
        
        	putSolutions(TEST ? randomT(n) : scanner.nextInt(), t, n);
        	
        }
        scanner.close();

        System.out.println(getSolution());
        
        if(TEST){
        	System.out.println((System.currentTimeMillis()-t0) + " ms");
        	
        }

	}


	private static int getSolution() {
		
		int currSol;

		for (int startPosition = 0; startPosition < n; startPosition++) {
			
			currSol = solutions[startPosition] + solutions[startPosition+n]; 
			
			if(currSol>bestSolution){
				
				bestSolution = currSol;
				bestPosition = startPosition;
			}
			
			
		}
		
		return bestPosition +1;
	}

	private static int randomT(int n) {
		return 1;
//		return RANDOM.nextInt(MAX_N + 1);
	}

	

	private static void putSolutions(int studentTime, int studentPosition, int studentSize) {
		
//		int relPosition =0;
		
		for (int i = studentPosition + 1 ; i <= studentPosition + studentSize - studentTime; i++) {
			
//			relPosition = studentPosition + i;
//			relPosition = relPosition >= studentSize ? relPosition - studentSize : relPosition; 
			
//			relPosition = studentPosition+i >= studentSize ? studentPosition+i - studentSize: studentPosition+i;
			
//			relPosition = (studentPosition+i)%studentSize;
			
			solutions[i]++;
				
			
		}
		
	}
	


}
