package a_allcontests.universityCodeSprint.n2_HackerlandRadioTransmitters;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionBackup {
	
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
			
			/*
			 * If already covered
			 */
			
			if(firstUncovered == 0){
				
				if(!isCovered(currentPosition, transmitterRange, trasmitterMap)){
					
					firstUncovered = currentPosition;
				}else{
					
					previousPosition = currentPosition;
					continue;
					
				}
				
			}
			
			if(currentPosition!=lastPosition && 
					isPotentiallyCovered(firstUncovered, transmitterRange, currentPosition) 
					){
				
				previousPosition = currentPosition;
				continue;
			}
			
			if(currentPosition == lastPosition){
				
				if(trasmitterMap.size()==0 || 
						trasmitterMap.get(trasmitterMap.size()-1) + transmitterRange < currentPosition){
					
					
					trasmitterMap.add(currentPosition);
					
				}
				
				
				break;
				
			}
			
			
			if(transmitterRange == currentPosition-firstUncovered){
				
				trasmitterMap.add(currentPosition);
				firstUncovered = 0;
				
			}else{
				
				trasmitterMap.add(previousPosition);

				if(currentPosition-previousPosition <= transmitterRange){
					
					firstUncovered = 0;
					
				}else{
					firstUncovered = currentPosition;
				}
				
			
			}
			
			
			
			
			
			
			
			previousPosition = currentPosition;
		}
		
		return trasmitterMap.size();
	}

	private static boolean isCovered(Integer currentPosition, int transmitterRange, List<Integer> trasmitterMap) {

		if(trasmitterMap.size() == 0){
			return false;
		}
		
		
		return trasmitterMap.get(trasmitterMap.size()-1) + transmitterRange >= currentPosition;
	}

	private static boolean isPotentiallyCovered(int firstUncovered, int transmitterRange, Integer currentPosition) {
		
		
		
		return transmitterRange > currentPosition-firstUncovered;
	}
}
