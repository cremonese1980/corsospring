package a_allcontests.projecteuler.n_001;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	

	private static final BigInteger TWO = new BigInteger(String.valueOf(2));
	private static final BigInteger THREE = new BigInteger(String.valueOf(3));
	private static final BigInteger FIVE = new BigInteger(String.valueOf(5));
	private static final BigInteger FIFTEEN = new BigInteger(String.valueOf(15));
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        long start;
        
        long tSolution=0;
        
        BigInteger solution;
        
//        System.out.println("=============================================");
//        System.out.printf("%-10s", "#");
//        System.out.printf("%-10s", "N");
//        System.out.printf("%-20s", "result");
//        System.out.printf("%-20s%n", "ms");
        
        
        
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
//            start = System.currentTimeMillis();
//            solution = firstSolution(n);
//            tSolution= System.currentTimeMillis()-start;
//            printSolution(1, solution, tSolution, n);
            
            start = System.currentTimeMillis();
            solution = thirdSolution(n);
            System.out.println(solution);
            tSolution= System.currentTimeMillis()-start;
//            printSolution(3, solution, tSolution, n);
            
        }
        
        in.close();
        
//        System.out.println("=============================================");
    }
	
	private static BigInteger thirdSolution(int n) {
		
		n--;
		
		BigInteger target = new BigInteger(String.valueOf(n));
		
		BigInteger multiple_3;
		BigInteger multiple_5;
		BigInteger multiple_15;
		
		multiple_3 = THREE.multiply(sumFirstN(target.divide(THREE)));
		multiple_5 = FIVE.multiply(sumFirstN(target.divide(FIVE)));
		multiple_15 = FIFTEEN.multiply(sumFirstN(target.divide(FIFTEEN)));
		
		return multiple_3.add(multiple_5).subtract(multiple_15);
	}
	
	private static BigInteger sumFirstN(BigInteger n){
		
		
		return n.multiply(n.add(BigInteger.ONE)).divide(TWO);
		
		
	}

	private static void printSolution(int solutionNumber, BigInteger solution, long tSolution, int n){
		
		System.out.printf("%-10s", solutionNumber);
		System.out.printf("%-10s", n);
        System.out.printf("%-20d", solution);
        System.out.printf("%-20d%n", tSolution);
        
	}


	private static BigInteger firstSolution(int n) {

		n--;
		BigInteger solution = BigInteger.ZERO;
		
		for (int i = 3; i <= n; i++) {

			if(i%3 == 0 || i%5 == 0){
				
				solution = solution.add(new BigInteger(String.valueOf(i)));
			}
			
			
		}
		
		return solution;
	}

}
