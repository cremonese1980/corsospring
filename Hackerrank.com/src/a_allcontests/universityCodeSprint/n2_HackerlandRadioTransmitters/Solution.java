package a_allcontests.universityCodeSprint.n2_HackerlandRadioTransmitters;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private static final int EMPTY = 0;
	private static final int HOUSE = 1;
	private static final int HOUSE_AND_TRANSMITTER = 2;
	
	private static Map<Integer, Integer> city = new TreeMap<Integer, Integer>();

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int numberOfHouses = in.nextInt();
        int transmitterRange = in.nextInt();
        
        int[] positionMap = new int[numberOfHouses];
        
        int firstPosition = 100000;
        int lastPosition = 1;
        
        for(int currentHouse=0; currentHouse < numberOfHouses; currentHouse++){
        	
            positionMap[currentHouse] = in.nextInt();
            
            if(positionMap[currentHouse] < firstPosition){
            	firstPosition = positionMap[currentHouse]; 
            }
            
            if(positionMap[currentHouse] > lastPosition){
            	lastPosition = positionMap[currentHouse]; 
            }
            city.put(positionMap[currentHouse], HOUSE);
            
        }
        in.close();
        
        
        int numberOfTransmitters = getSolution(numberOfHouses, transmitterRange, positionMap, firstPosition, lastPosition);
        
        
        System.out.println(numberOfTransmitters);
        
        
    }

	private static int getSolution(int numberOfHouses, int transmitterRange, int[] positionMap, int firstPosition,
			int lastPosition) {

		int numberOfTransmitters = 0;
		int previousPosition = -1;
		int uncovered = 0;
		
		for (Integer currentPosition : city.keySet()) {
			
			if(previousPosition == -1){
				
				previousPosition = currentPosition;
				continue;
				
			}
			
			uncovered+= currentPosition-previousPosition;
			
			if(uncovered>=transmitterRange/2){
				numberOfTransmitters++;
				uncovered = uncovered - transmitterRange;
			}
			
			previousPosition = currentPosition;
		}
		
		return numberOfTransmitters;
	}
}
