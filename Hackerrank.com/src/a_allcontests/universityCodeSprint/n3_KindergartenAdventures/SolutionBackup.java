package a_allcontests.universityCodeSprint.n3_KindergartenAdventures;

import java.util.Scanner;

public class SolutionBackup {
	
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
		
		for (int i = 0; i < size; i++) {
			
			int sum = students[i] <= 0 ? 1 : 0;
			
			for (int j = i+1; j < i + size; j++) {
				
				int index = j%(size);
				
				sum+= (students[index] - (j-i)) <= 0 ? 1 : 0;
				
			}
			
			if(sum>maxSum){
				maxSum = sum;
				result = i;
			}
			
		}

		return result + 1;
	}
}
