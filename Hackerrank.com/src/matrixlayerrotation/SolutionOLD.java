package matrixlayerrotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionOLD {

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int rowSize = in.nextInt();
        int columnSize = in.nextInt();
        int rotationSize = in.nextInt();
        
        int[] matrix = new int[rowSize*columnSize];
        
        int ringSize = Math.min(rowSize, columnSize)/2;
        
        int [] currentIndexes = new int[ringSize];
        int [] subArraySize = new int[ringSize+1];
        
        int previousSize = 0;
        currentIndexes[0] = 0;
        
        for (int i = 0; i < currentIndexes.length-1; i++) {
        	
        	if(i>0){
        		previousSize+= currentIndexes[i];
        	}
			
			currentIndexes[i+1] = getFirstIndexByRing(i, rowSize, columnSize, previousSize);
			subArraySize[i+1] = currentIndexes[i+1];
			
		}
        subArraySize[subArraySize.length-1] = matrix.length;
        
        int currentRow = 0;
        int currentColumn = 0;
        
        int currentRing = 0;
        
        int currentValue;
        
        int destinationIndex;
        
        int currentRingSize;
        
        boolean increaseIndex = true;
        
        for(int currentIndex = 0; currentIndex < matrix.length; currentIndex++){
        	
        	increaseIndex = true;
        	
        	currentRing = getCurrentRing(currentRow, currentColumn, rowSize, columnSize, ringSize);
        	
        	
        	currentValue = in.nextInt();
        	
        	currentRingSize = subArraySize[currentRing+1] - subArraySize[currentRing];
        	
        	if(currentRing == currentRow){
        		
        		destinationIndex = currentIndexes[currentRing] ;
        		
        	}else if(currentRow == rowSize - currentRing -1){
        		
        		increaseIndex = false;
        		destinationIndex = currentIndexes[currentRing] + (rowSize-1 -currentColumn) - currentRing;
        		
        	}else{
        		
        		if(currentColumn==currentRing){
        			
        			destinationIndex = currentRingSize - 1 - (currentRow-1); 
        			increaseIndex = false;
        			
        		}else{
        			
        			
        			destinationIndex = currentIndexes[currentRing] ;
        		}
        		
        	}
        	matrix[destinationIndex] = currentValue;
        	if(increaseIndex){
        		
        		currentIndexes[currentRing]++;
        	}
        	
        	
        	if((currentIndex +1) % columnSize == 0){
        		currentRow++;
        		currentColumn = 0;
        	}else{
        		
        		currentColumn++;
        	}
        	
        }
        in.close();
        
        for (int i = 0; i < matrix.length; i++) {

        	System.out.print(matrix[i]+ " " );
        	
		}
        
        
        matrix = rotate(matrix, rotationSize, rowSize, columnSize, subArraySize);
        
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {

        	System.out.print(matrix[i]+ " " );
        	
		}
        
//        printMatrix(matrix, columnSize);
        
//        System.out.println(checkEffectiveRotation(30, 4, 5));
        
        currentRow = 0;
        currentColumn = 0;
        
        currentRing = 0;
        
        System.out.println("");
        
        for(int currentIndex = 0; currentIndex < matrix.length; currentIndex++){
        	
        	currentRing = getCurrentRing(currentRow, currentColumn, rowSize, columnSize, ringSize);
        	
        	currentValue = matrix[subArraySize[currentRing]];
        	subArraySize[currentRing]++;
        	
        	System.out.print(currentValue + " ");
        	
        	if((currentIndex +1) % columnSize == 0){
        		currentRow++;
        		currentColumn = 0;
        		System.out.println("");
        	}else{
        		
        		currentColumn++;
        	}
        	
        	
        }
        
        
    }
    
    private static int getFirstIndexByRing(int ringId, int rowSize, int columnSize, int previuousSize) {

    	int ringSize = 2*(rowSize-1 - ringId*2) + 2*(columnSize-1 - ringId*2);
    	
    	return ringSize + previuousSize;
    	
	}

	private static int getCurrentRing(int currentRow, int currentColumn, int rowSize, int columnSize, int ringSize) {

    	int rowReference = currentRow +1 > rowSize/2 ? rowSize -1 : 0;
    	int colReference = currentColumn +1 >= columnSize/2 ? columnSize -1 : 0;
    	
    	int rowDistance = rowReference == 0 ? currentRow : rowSize-1 -currentRow;
    	
    	int colDistance = colReference == 0 ? currentColumn : columnSize-1 -currentColumn;
    	
    	return Math.min(rowDistance, colDistance);
	}

	private static int[] rotate(int[] originalMatrix,
			int rotationSize, int rowSize, int columnSize, int[] subArraySize) {

    	int[] rotatedMatrix=new int[0];
    	
    	int effectiveRotation = checkEffectiveRotation(rotationSize, rowSize, columnSize);
    	int[] partial;
    	
    	for (int i = 0; i < subArraySize.length-1; i++) {
			
			partial = rotate( Arrays.copyOfRange(originalMatrix, subArraySize[i], subArraySize[i+1]), effectiveRotation);
			rotatedMatrix = concat(rotatedMatrix, partial);
		}
    	
    	
    	return rotatedMatrix;
	}
	
	private static int[] concat(int[] a, int[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   int[] c= new int[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}

	
	private static int[] rotate(int[] array, int numberOfRotations) {

		int[] rotated = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			rotated[Math.abs((i-numberOfRotations+array.length)) %array.length] = array[i];
			
			
		}
		
		return rotated;
	}
	
	private static int checkEffectiveRotation(int rotationSize, int rowSize, int columnSize) {

		
		return rotationSize % ((rowSize-1)*2 + (columnSize-1)*2);
	}


}


