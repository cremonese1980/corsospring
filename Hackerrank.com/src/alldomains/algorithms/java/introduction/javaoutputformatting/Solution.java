package alldomains.algorithms.java.introduction.javaoutputformatting;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
            Scanner scanner=new Scanner(System.in);
            
            System.out.println("================================");
            
            for(int i=0;i<3;i++)
            {
                String s1=scanner.next();
                int x=scanner.nextInt();
                
                
//                System.out.printf("%-15%");
                System.out.printf("%-15s", s1);
                System.out.printf("%03d%n", x);
                
            }
            System.out.println("================================");

    }
}
