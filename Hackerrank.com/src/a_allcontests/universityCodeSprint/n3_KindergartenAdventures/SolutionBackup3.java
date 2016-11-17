package a_allcontests.universityCodeSprint.n3_KindergartenAdventures;

import java.util.Random;
import java.util.Scanner;

public class SolutionBackup3 {
	
	private static final int MAX_N = 50000;
	private static final boolean TEST = true;
	private static final Random RANDOM = new Random();
	
	private static int [] solutions;
	
	private static int bestSolution = 0;
	private static int bestPosition = 0;
	
	public static void main(String[] args) {
		
		long t0 = System.currentTimeMillis();
		
		Scanner scanner = new Scanner(System.in);
        
        int n = TEST ? MAX_N : scanner.nextInt();
        
        solutions = new int[n];
        
        for(int t = 0; t < n - 1; t++){
        
        	putSolutions(TEST ? randomT(n) : scanner.nextInt(), t, n);
        	
        }
        putLastSolutions(TEST ? randomT(n) : scanner.nextInt(), n-1, n);
        scanner.close();

        System.out.println(bestPosition+1);
        
        if(TEST){
        	System.out.println((System.currentTimeMillis()-t0) + " ms");
        	
        }

	}


	private static int randomT(int n) {
		return RANDOM.nextInt(MAX_N + 1);
	}

	
	private static void putSolutions(int studentTime, int studentPosition, int studentSize) {

		int relPosition=studentPosition;
		
			
		for (int startPosition = studentPosition-2; startPosition >= 0; startPosition--) {
			
//			relPosition = studentPosition - startPosition;
//			relPosition = relPosition >=0 ? relPosition : studentSize + relPosition; 
			
			
			if(relPosition - studentTime >= 0){
				
				solutions[startPosition]++;
				
			}
			relPosition--;
			
		}
		
		relPosition = studentSize + studentPosition;
		
//		for (int startPosition = studentPosition; startPosition < studentSize; startPosition++) {
			
		for (int startPosition = studentSize-1; startPosition >= studentPosition; startPosition--) {
			
//			relPosition = relPosition - startPosition;
			
			if(relPosition - studentTime >= 0){
				
				solutions[startPosition]++;
				
			}
			relPosition--;
			
		}
	}
	

//	private static void putSolutions(int studentTime, int studentPosition, int studentSize) {
//
//		int relPosition =9;
//		
//			
//		for (int startPosition = 0; startPosition < studentSize; startPosition++) {
//			
//			relPosition = studentPosition - startPosition;
//			relPosition = relPosition >=0 ? relPosition : studentSize + relPosition; 
//			
//			
//			if(relPosition - studentTime >= 0){
//				
//				solutions[startPosition]++;
//				
//			}
//			
//		}
//		
//	}
	
	private static void putLastSolutions(int studentTime, int studentPosition, int studentSize) {

		int relPosition;
		
			
			for (int startPosition = 0; startPosition < studentSize; startPosition++) {
				
				relPosition = studentPosition - startPosition;
				relPosition = relPosition >=0 ? relPosition : studentSize + relPosition; 
				
				if(relPosition - studentTime >= 0){
					
					solutions[startPosition]++;
					
				}
				
				if(solutions[startPosition]>bestSolution){
					bestSolution = solutions[startPosition];
					bestPosition = startPosition;
				}
				
				
			}
		
	}


}
