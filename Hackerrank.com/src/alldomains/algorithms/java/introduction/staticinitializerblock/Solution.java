package alldomains.algorithms.java.introduction.staticinitializerblock;

import java.util.Scanner;



class Solution{
	
	private static final String ERROR_MESSAGE = "java.lang.Exception: Breadth and height must be positive";
	
	private static boolean flag;
	private static int B,H;
	private static Scanner scanner;

	static{
		
		scanner = new Scanner(System.in);
		
		B = scanner.nextInt();
		H = scanner.nextInt();
		
		if(B <= 0 || H <= 0){
			
			System.out.println(ERROR_MESSAGE);
			
		}else{
			
			flag = true;
			
		}
		
	}
	
	
    public static void main(String[] args){
		
    	if(flag){
			int area=B*H;
			System.out.print(area);
		}    	
		
	}//end of main

}//end of class

