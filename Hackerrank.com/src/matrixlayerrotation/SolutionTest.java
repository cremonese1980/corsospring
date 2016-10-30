package matrixlayerrotation;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGetNewPosition() {
		
		
//		Solution.getNewPosition(row, column, currentRing, rowSize, colSize, realRotationValue);
	
	}
	
	

	@Test
	public void testMoveToNorth() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveToEst() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveToSouth() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveToWest() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentRelativeLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckEffectiveRotation() {
		
		int rotationSize = 40;
		
		int rowSize = 10;
		int columnSize = 8;
		int ringId = 0;
		int ringSize = Solution.getRingSize(ringId, columnSize, rowSize);
		Solution.checkEffectiveRotation(rotationSize, ringSize);
		
	}

	@Test
	public void testGetCurrentRing() {
		
		
//		int columnSize = 87;
//		int rowSize = 65;
		
		int columnSize = 163;
		int rowSize = 85;
		
		int totalRings = Solution.getTotalRings(rowSize, columnSize);
//		int ringId = getRandomRing(totalRings);
		
//		int ringSize = Solution.getRingSize(ringId, columnSize, rowSize);
		
		int[] countedElements = new int[totalRings];
		
		

        for (int row = 0; row < rowSize; row++) {
			
        	
        	for (int column = 0; column < columnSize; column++) {
        		
        		if(row == 3 && column == 2){
        			
        			int stop = 9;
        			System.out.println(stop);
        		}
        		
        		
        		int currentRing = Solution.getCurrentRing(row, column, rowSize, columnSize);

        		if(currentRing>=totalRings){
        			
        			System.out.println("Here there is the error. Row " + row +
        					", Col " + column + ". current ring " + currentRing + 
        					", total rings " + totalRings);
        			
        		}else{
        			countedElements[currentRing]++;
        			
        		}
        	}
        	
        }
        
        for (int i = 0; i < countedElements.length; i++) {

        	System.out.print("Ring [" + i + "] counted [" + countedElements[i] + "]. ");
        	System.out.println("Should be [" + Solution.getRingSize(i, columnSize, rowSize) + "]");
        	
        	assertTrue(countedElements[i] == Solution.getRingSize(i, columnSize, rowSize));
		}
		
		
	}
	
	@Test
	public void testRingSize(){
		
		
		
		int columnSize = 2;
		int rowSize = 300;
		int area = columnSize*rowSize;
		
		int totalRings = Solution.getTotalRings(rowSize, columnSize);
		
		int totalRingSize = 0;
		
		for (int i = 0; i < totalRings; i++) {

			
			int currentRingSize = Solution.getRingSize(i, columnSize, rowSize);
			
			totalRingSize+= currentRingSize;
			
		}
		
		assertTrue(area == totalRingSize);
		
		System.out.println("Area efectiva calculada a la manera de la abuela: " + area);
		System.out.println("Area supuestamente efectiva calculada con los anillos: " + totalRingSize);
		
		System.out.println("Si los dos valores de antes no son iguales, eres un cabron");

		
		
		
		
	}


}
