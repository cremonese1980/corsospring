package a_allcontests.universityCodeSprint.n1_minMaxSum;


import java.util.Scanner;

public class Solution {
	
	private static long min;
	private static long max;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long input[] = new long[]{a, b, c, d, e};
        
        computeMinAndMax(input, a+b+c+d+e);
        
        System.out.println(min + " " + max);
        
        in.close();
    }

	private static void computeMinAndMax(long input[], long total) {

		long currMin = Long.MAX_VALUE;
		long currMax = 0;
		
		for (int i = 0; i < input.length; i++) {

			
			long currInput = input[i];
			
			if(total - currInput > currMax){
				
				currMax = total - currInput;
				
			}
			
			if(total - currInput < currMin){
				
				currMin = total - currInput;
			}
			
			
		}
		
		min = currMin;
		max = currMax;
		
	}
}
