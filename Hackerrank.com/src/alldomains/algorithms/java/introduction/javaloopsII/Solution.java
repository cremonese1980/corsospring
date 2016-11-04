package alldomains.algorithms.java.introduction.javaloopsII;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
            Scanner scanner=new Scanner(System.in);
            
            int q = scanner.nextInt();
            
            for(int i=0; i<q; i++){
            	
            	int a = scanner.nextInt();
            	int b = scanner.nextInt();
            	int n = scanner.nextInt();
            	
            	printSerie(a, b, n);
                
            }
            
            scanner.close();

    }
    
    private static void printSerie(int a, int b, int n){
    	
    	int res = a;
    	
    	for(int i=0; i<n; i++){
    		
    		res+= (int)Math.pow(2, i)*b;
    		System.out.print(res+ " ");
    		
    	}
    	System.out.println("");
    	
    	
    }
}
