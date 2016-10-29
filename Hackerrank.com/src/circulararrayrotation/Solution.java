package circulararrayrotation;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int arraySize = in.nextInt();
        int numberOfRotations = in.nextInt();
        int querySize = in.nextInt();
        int[] array = new int[arraySize];
        
        for(int a_i=0; a_i < arraySize; a_i++){
        	array[a_i] = in.nextInt();
        }
        
        int[] queryArray = new int[querySize];
        for(int a0 = 0; a0 < querySize; a0++){
            
            queryArray[a0] = in.nextInt();
        }
        
        in.close();
        
//        for (int i = 0; i < numberOfRotations; i++) {
//        	
//        	array = rotate(array);
//			
//		}
        
        array = rotate(array, numberOfRotations);
        
        for(int a0 = 0; a0 < querySize; a0++){
            System.out.println(array[queryArray[a0]]);
        }
    }
    
    private static int[] rotate(int[] array, int numberOfRotations) {

		int[] rotated = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			rotated[(i+numberOfRotations)%array.length] = array[i];
			
		}
		
		return rotated;
	}

	private static int[] rotate(int[] array) {

		int[] rotated = new int[array.length];
		
		rotated[0] = array[array.length-1];
		
		for (int i = 0; i < array.length-1; i++) {
			
			rotated[i+1] = array[i];
			
		}
		
		return rotated;
	}
}
