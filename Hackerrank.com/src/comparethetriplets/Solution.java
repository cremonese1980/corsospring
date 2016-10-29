package comparethetriplets;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
           int a0 = in.nextInt();
           int a1 = in.nextInt();
           int a2 = in.nextInt();
           int b0 = in.nextInt();
           int b1 = in.nextInt();
           int b2 = in.nextInt();
           
           int[] aliceScore = new int[]{a0, a1, a2};
           int[] bobScore = new int[]{b0, b1, b2};
        
        in.close();
        

        int alicePoint = 0;
        int bobPoint = 0;
        
        for (int i = 0; i < 3; i++) {

        	if(aliceScore[i]>bobScore[i]){
        		alicePoint++;
        	}else  if(aliceScore[i]<bobScore[i]){
        		bobPoint++;
        	}
        	
		}
        
        System.out.println(alicePoint + " " + bobPoint  );
        
        
    }
    
}
