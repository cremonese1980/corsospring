package emma;

import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        int numberOfFriends = scanner.nextInt();
        int remainingFotos = scanner.nextInt();
        
        int combinatios = getResult(numberOfFriends);
        
        int print = Math.abs(combinatios-remainingFotos);
        
        scanner.close();
        
        System.out.println(print);
        
        
    }

	private static int getResult(int n) {

		int totalComb = 0;
		
		for (int i = n; i >= 1; i--) {
		
			totalComb+= getCombinations(n, i);
			
		}
		
		return totalComb;
	}
    
    
	private static int getCombinations(int n, int k) {

		return factorial(n)/((factorial(n-k)* factorial(k)));
	}

	private static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

}


