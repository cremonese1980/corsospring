package alldomains.algorithms.java.introduction.endoffile;

import java.util.Scanner;



class Solution{
	
    private static final String END_OF_FILE = "end-of-file.";

	public static void main(String []argh){

        Scanner sc = new Scanner(System.in);
        
        boolean endOfFile = false;
        int index = 1;
        
        while(!endOfFile){
        	
        	String currentLine = sc.nextLine();
        	
        	endOfFile = currentLine.endsWith(END_OF_FILE) ? true : false;
        	
        	System.out.println(index + " " + currentLine);
        	
        	index++;
        }

        
        sc.close();
    }
}
