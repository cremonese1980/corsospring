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
        
        
        int numberOfTransmitters = getSolution(city.keySet().size(), transmitterRange, positionMap, firstPosition, lastPosition);
        
        
        System.out.println(numberOfTransmitters);
        
        
    }

	private static int getSolution(int numberOfHouses, int transmitterRange, int[] positionMap, int firstPosition,
			int lastPosition) {
		
		
		if(numberOfHouses == 1){
			return 1;
		}

		int previousPosition = -1;
		int firstUncovered = firstPosition;
		
		List<Integer> trasmitterMap = new LinkedList<Integer>();
		
		
		for (Integer currentPosition : city.keySet()) {
			
			
			/*
			 * Just first time
			 */
			if(previousPosition == -1){
				
				previousPosition = currentPosition;
				continue;
				
			}
			
			
			if(isCovered(currentPosition, transmitterRange, trasmitterMap)){
				previousPosition = currentPosition;
				continue;
			}else{
				
				if(firstUncovered == 0){
					firstUncovered = currentPosition;
				}
				
//				if(currentPosition == lastPosition){
//					trasmitterMap.add(currentPosition);
//					break;
//				}
				
			}
			
			int distanceFromFirstUncovered = currentPosition-firstUncovered; 
			
			if(distanceFromFirstUncovered < transmitterRange){
				
				previousPosition = currentPosition;
			}
			
			
			if(distanceFromFirstUncovered == transmitterRange){
				
				trasmitterMap.add(currentPosition);
				previousPosition = currentPosition;
				firstUncovered = 0;
				
			}
			
			if(distanceFromFirstUncovered > transmitterRange){
				
				
				trasmitterMap.add(previousPosition);
				
				if(currentPosition - previousPosition > transmitterRange){
						
					firstUncovered = currentPosition;
				}else{
					
					firstUncovered = 0;
				}
				previousPosition = currentPosition;
				
			}
			
			
			if(currentPosition == lastPosition &&
					!isCovered(currentPosition, transmitterRange, trasmitterMap)){
				
				trasmitterMap.add(currentPosition);
				break;
			}
			
			
			
//			previousPosition = currentPosition;
		}
		
		return trasmitterMap.size();
	}

	private static boolean isCovered(Integer currentPosition, int transmitterRange, List<Integer> trasmitterMap) {

		if(trasmitterMap.size() == 0){
			return false;
		}
		
		
		return trasmitterMap.get(trasmitterMap.size()-1) + transmitterRange >= currentPosition;
	}

}
