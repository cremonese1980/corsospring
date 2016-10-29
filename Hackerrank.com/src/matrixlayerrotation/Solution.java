package matrixlayerrotation;

import java.util.Scanner;

public class Solution {
	
	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int WEST = 2;
	private static final int EAST = 3;

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int rowSize = in.nextInt();
        int columnSize = in.nextInt();
        int rotationValue = in.nextInt();
        
        int realRotationValue = checkEffectiveRotation(rotationValue, rowSize, columnSize);
        
        int currentRing = 0;
        
        int currentValue;
        int ringSize = Math.min(rowSize, columnSize)/2;
        
        int[][] matrix = new int[rowSize][columnSize];
        
        int[][] rotatedMatrix = new int[rowSize][columnSize];
        
        for (int row = 0; row < rowSize; row++) {
			
        	
        	for (int column = 0; column < columnSize; column++) {

        		
        		currentRing = getCurrentRing(row, column, rowSize, columnSize, ringSize);
            	currentValue = in.nextInt();
            	
            	matrix[row][column] = currentValue;
            	
            	int newPosition[] = getNewPosition(row, column, currentRing, rowSize, columnSize, realRotationValue);
            	
            	rotatedMatrix[newPosition[0]][newPosition[1]] = currentValue;
        		
			}
			
		}
        
        in.close();
        
       
        
//        printMatrix(matrix, rowSize, columnSize);
//        
//        System.out.println("");
        
        printMatrix(rotatedMatrix, rowSize, columnSize);
        
        
        
        
    }
    
    
    
    private static int[] getNewPosition(int row, int column, int currentRing, int rowSize, int colSize, int realRotationValue) {
		
    	int currentLocation = getCurrentRelativeLocation(row, column, currentRing, rowSize, colSize);
    	
    	
    	switch (currentLocation) {
    	
		case NORTH:
			return moveToWest(row, column, currentRing, rowSize, colSize, realRotationValue);
			
		case SOUTH:
			return moveToEst(row, column, currentRing, rowSize, colSize, realRotationValue);
			
		case WEST:
			return moveToSouth(row, column, currentRing, rowSize, colSize, realRotationValue);
			
		case EAST:
			return moveToNorth(row, column, currentRing, rowSize, colSize, realRotationValue);

		}
    	
		return null;
	}



	private static int[] moveToNorth(int row, int column, int currentRing, int rowSize, int colSize,
			int realRotationValue) {

		int[] newPosition = new int[2];
		
		int distanceFromNorth = row - currentRing;
		
		if(realRotationValue > distanceFromNorth){
			
			return moveToWest(currentRing, column, currentRing, rowSize, colSize, realRotationValue-distanceFromNorth);
			
		}else{
			
			newPosition[0] = row -realRotationValue;
			newPosition[1] = column;
			
		}
		
		
		return newPosition;
	}



	private static int[] moveToEst(int row, int column, int currentRing, int rowSize, int colSize,
			int realRotationValue) {
		
		int[] newPosition = new int[2];
		
		int distanceFromEast = colSize -1 - currentRing - column;
		
		if(realRotationValue > distanceFromEast){
			
			return moveToNorth(row, colSize-1-currentRing, currentRing, rowSize, colSize, realRotationValue-distanceFromEast);
			
		}else{
			
			newPosition[0] = row;
			newPosition[1] = column + realRotationValue;
			
		}
		
		
		return newPosition;
	}



	private static int[] moveToSouth(int row, int column, int currentRing, int rowSize, int colSize,
			int realRotationValue) {
		
		
		int[] newPosition = new int[2];
		
		int distanceFromSouth = rowSize -1 -currentRing - row;
		
		if(realRotationValue > distanceFromSouth){
			
			return moveToEst(rowSize-1-currentRing, column, currentRing, rowSize, colSize, realRotationValue-distanceFromSouth);
			
		}else{
			
			newPosition[0] = row + realRotationValue;
			newPosition[1] = column;
			
		}
		
		
		return newPosition;
	}



	private static int[] moveToWest(int row, int column, int currentRing, int rowSize, int colSize,
			int realRotationValue) {
		
		
		int[] newPosition = new int[2];
		
		int distanceFromWest = column - currentRing;
		
		if(realRotationValue > distanceFromWest){
			
			return moveToSouth(row, currentRing, currentRing, rowSize, colSize, realRotationValue-distanceFromWest);
			
		}else{
			
			newPosition[0] = row;
			newPosition[1] = column-realRotationValue;
			
		}
		
		
		return newPosition;
		
	}



	private static int getCurrentRelativeLocation(int row, int column, int currentRing, int rowSize, int colSize) {
		
		if(row == currentRing){
			if(column == currentRing){
				return WEST;
			}
			return NORTH;
		}
		if(row == rowSize - 1 - currentRing){
			if(column == colSize -1 - currentRing){
				return EAST;
			}
			return SOUTH;
		}
		if(column == currentRing){
			if(row == rowSize - 1 - currentRing){
				return SOUTH;
			}
			return WEST;
		}
		if(column == colSize -1 - currentRing){
			if(row == currentRing){
				return NORTH;
			}
			return EAST;
		}
		
		return 0;
	}



	private static void printMatrix(int[][] matrix, int rowSize, int columnSize) {
    	 
    	for (int row = 0; row < rowSize; row++) {
 			
         	
         	for (int column = 0; column < columnSize; column++) {
         		
         		System.out.print(matrix[row][column]+ " " );
         	}
         
         
         	System.out.println("");
         
         }
		
	}



	private static int checkEffectiveRotation(int rotationSize, int rowSize, int columnSize) {

		
		return rotationSize % ((rowSize-1)*2 + (columnSize-1)*2);
	}


	
    
    
    private static int getCurrentRing(int currentRow, int currentColumn, int rowSize, int columnSize, int ringSize) {

    	int rowReference = currentRow +1 > rowSize/2 ? rowSize -1 : 0;
    	int colReference = currentColumn +1 >= columnSize/2 ? columnSize -1 : 0;
    	
    	int rowDistance = rowReference == 0 ? currentRow : rowSize-1 -currentRow;
    	
    	int colDistance = colReference == 0 ? currentColumn : columnSize-1 -currentColumn;
    	
    	return Math.min(rowDistance, colDistance);
	}

	


}


