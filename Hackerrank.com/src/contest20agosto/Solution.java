package contest20agosto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			int numberOfBags = Integer.parseInt(br.readLine());
			final String[] inputLine = br.readLine().split(" ");
			List<Integer> bagList = new ArrayList<Integer>();
			int totalApples = 0;
			
			int currentBagSize;
			for (int i = 0; i < inputLine.length; i++) {
				currentBagSize= Integer.parseInt(inputLine[i]);
				bagList.add(currentBagSize);
				totalApples+=currentBagSize;
			}
			
			if(totalApples%3==0){
				System.out.println(totalApples);
				return;
			}
			
			Collections.sort(bagList);
			
			List<Integer> solutions = new ArrayList<Integer>();
			
			solutions.add(remove(1,1,bagList,totalApples));
			solutions.add(remove(2,2,bagList,totalApples));
			solutions.add(remove(1,2,bagList,totalApples));
			solutions.add(remove(2,1,bagList,totalApples));
			
			Collections.sort(solutions);

			System.out.println(""+ solutions.get(solutions.size()-1));
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
	private static int remove(int howMany, int howMuch, List<Integer> list, int totalApples){
		
		int toRemove = 0;
		int removed=0;
		
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer bag =  iterator.next();
			
			if(bag%3==howMuch){
				toRemove+= bag;
				removed++;
			}
			if(removed==howMany){
				break;
			}
			
		}
		
		
		return (totalApples-toRemove)%3==0 ? totalApples-toRemove: 0 ;
		
	}
	
}


