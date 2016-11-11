package a_allcontests.projecteuler.n_13_large_sum;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	
	
	private static BigInteger sum = BigInteger.ZERO;
	
	
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++){
        	
            BigInteger n = new BigInteger(in.next());
            
            sum = sum.add(n);
            
        }
        
        String solution = getSolution(sum);
        
        System.out.println(solution);
        
        in.close();
    }

	private static String getSolution(BigInteger n) {

		String solution = n.toString().substring(0, 10);
		
		
		
		return solution;
	}

}
