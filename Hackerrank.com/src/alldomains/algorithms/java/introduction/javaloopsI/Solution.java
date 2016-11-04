package alldomains.algorithms.java.introduction.javaloopsI;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
            Scanner scanner=new Scanner(System.in);
            
            int n = scanner.nextInt();
            
            for(int i=1;i<=10;i++)
            {
               
                System.out.println(n + " x " + i + " = "+ i*n);                
            }

    }
}
