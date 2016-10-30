package matrixlayerrotation;

import java.util.Scanner;

public class Solution {
	
	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int WEST = 2;
	private static final int EAST = 3;

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        int rowSize = scanner.nextInt();
        int columnSize = scanner.nextInt();
        int rotationValue = scanner.nextInt();
        
        int currentRing = 0;
        
        int currentValue;
        int totalRings = getTotalRings(rowSize, columnSize); 
        
        int [] rotationSizeByRing = getRotationSizeByRing(rotationValue, rowSize, columnSize, totalRings);  
        
        int[][] matrix = new int[rowSize][columnSize];
        
        int[][] rotatedMatrix = new int[rowSize][columnSize];
        
        for (int row = 0; row < rowSize; row++) {
			
        	
        	for (int column = 0; column < columnSize; column++) {

        		
        		currentRing = getCurrentRing(row, column, rowSize, columnSize);
            	currentValue = scanner.nextInt();
            	
            	matrix[row][column] = currentValue;
            	
            	int newPosition[] = getNewPosition(row, column, currentRing, rowSize, columnSize, rotationSizeByRing[currentRing]);
            	
            	rotatedMatrix[newPosition[0]][newPosition[1]] = currentValue;
        		
			}
			
		}
        
        scanner.close();
        
       
        
//        printMatrix(matrix, rowSize, columnSize);
//        
//        System.out.println("");
        
        printMatrix(rotatedMatrix, rowSize, columnSize);
        
        
        
        
    }
    
    
    
    private static int[] getRotationSizeByRing(int rotationValue, int rowSize, int columnSize, int totalRings) {

    	int[] rotationSizeByRing = new int[totalRings];
    	int currentRotationValue;
    	
    	for (int i = 0; i < rotationSizeByRing.length; i++) {

    		currentRotationValue = checkEffectiveRotation(rotationValue, getRingSize(i, columnSize, rowSize));
    		
    		rotationSizeByRing[i] = currentRotationValue;
    		
		}
    	
    	
    	return rotationSizeByRing;
	}



	public static int getTotalRings(int rowSize, int columnSize) {
		
    	
		return Math.min(rowSize, columnSize)/2;
	}



	public static int[] getNewPosition(int row, int column, int currentRing, int rowSize, int colSize, int realRotationValue) {
		
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



	public static int[] moveToNorth(int row, int column, int currentRing, int rowSize, int colSize,
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



	public static int[] moveToEst(int row, int column, int currentRing, int rowSize, int colSize,
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



	public static int[] moveToSouth(int row, int column, int currentRing, int rowSize, int colSize,
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



	public static int[] moveToWest(int row, int column, int currentRing, int rowSize, int colSize,
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



	public static int getCurrentRelativeLocation(int row, int column, int currentRing, int rowSize, int colSize) {
		
		if(row == currentRing){
			return NORTH;
		}
		if(row == rowSize - 1 - currentRing){
			return SOUTH;
		}
		if(column == currentRing){
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



	public static void printMatrix(int[][] matrix, int rowSize, int columnSize) {
    	 
    	for (int row = 0; row < rowSize; row++) {
 			
         	
         	for (int column = 0; column < columnSize; column++) {
         		
         		System.out.print(matrix[row][column]+ " " );
         	}
         
         
         	System.out.println("");
         
         }
		
	}



	public static int checkEffectiveRotation(int rotationSize, int ringSize) {

		
		return rotationSize % ringSize;
	}


	
    
    
    public static int getCurrentRing(int currentRow, int currentColumn, int rowSize, int columnSize) {

    	int rowReference = currentRow +1 > rowSize/2 ? rowSize -1 : 0;
    	int colReference = currentColumn +1 > columnSize/2 ? columnSize -1 : 0;
    	
    	int rowDistance = rowReference == 0 ? currentRow : rowSize-1 -currentRow;
    	
    	int colDistance = colReference == 0 ? currentColumn : columnSize-1 -currentColumn;
    	
    	return Math.min(rowDistance, colDistance);
	}

    public static int getRingSize(int ringId, int columnSize, int rowSize){
    	
    	return 2*(rowSize-1 - ringId*2) + 2*(columnSize-1 - ringId*2);
    }
	


}


