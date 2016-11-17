package a_allcontests.universityCodeSprint.n3_KindergartenAdventures;

import java.util.Scanner;

public class SolutionBackup2 {
	
	private static final int MAX_N = 50000;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int [] students = new int[n];
        
        for(int t = 0; t < n; t++){
        
        	students[t] = scanner.nextInt();
        	
        }
        scanner.close();

    	System.out.println(getSolution(students, n));

	}


	private static int getSolution(int[] students, int size) {

		int result = 0;
		int maxSum = 0;
		int currentSum;
		int currTrash = 0;
		int bestTrash = MAX_N;
		
		for (int i = 0; i < size; i++) {
			
			currentSum = students[i] <= 0 ? 1 : 0;
			
			currTrash = currentSum ==1 ? 0 :1;
			
			for (int j = i+1; j < i + size; j++) {
				
				if((students[j-size >=0?j-size: j] - (j-i)) <= 0){
					currentSum++;
				}else{
					currTrash++;
				}
				
				if(currTrash>bestTrash){
					break;
				}
			}
			
			if(currentSum>maxSum){
				maxSum = currentSum;
				result = i;
			}
			if(currTrash<bestTrash){
				bestTrash = currTrash;
			}
			
		}

		return result + 1;
	}
}
