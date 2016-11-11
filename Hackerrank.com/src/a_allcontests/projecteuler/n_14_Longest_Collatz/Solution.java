package a_allcontests.projecteuler.n_14_Longest_Collatz;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static final int MAX_N = 5000000;
	
	private static final int MAX_SIZE = 3732424;
	
	
	private static Map<Integer, Integer> sequenceArray;
	
	private static List<Integer> maxList;
	
	private static int [] thresholdArray = new int[]{
		3		,      
		6		,
		7		,
		9		,
		18		,
		19		,
		25		,
		27		,
		54		,
		55		,
		73		,
		97		,
		129		,
		171		,
		231		,
		235		,
		313		,
		327		,
		649		,
		654		,
		655		,
		667		,
		703		,
		871		,
		1161	,
		2223	,
		2322	,
		2323	,
		2463	,
		2919	,
		3711	,
		6171	,
		10971	,
		13255	,
		17647	,
		17673	,
		23529	,
		26623	,
		34239	,
		35497	,
		35655	,
		52527	,
		77031	,
		106239	,
		142587	,
		156159	,
		216367	,
		230631	,
		410011	,
		511935	,
		626331	,
	    837799	,
	    1117065,
	    1126015,
	    1501353,
	    1564063,
	    1723519,
	    2298025,
	    3064033,
	    3542887,
	    3732423};
	
	
	
	
	private static int globalMax = 0;
	
	
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
//        long t0 = System.currentTimeMillis();
//        buildData();
//        System.out.println(System.currentTimeMillis()-t0);
        
        
        int t = in.nextInt();
        
        
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            long solution = getSolution(n);
            
            System.out.println(solution);
        }
        
        in.close();
    }
	
	private static long getSolution(int n) {
		
		
		for (int i = thresholdArray.length-1; i >= 0; i--) {

			Integer currentNumber = thresholdArray[i];
			
			if(n>= currentNumber){
				
				return currentNumber;
				
			}
			
		}
		
		
		return 0;
	}

	private static long buildDataByN(int n) {

		int max = 0;
		long maxNum = 0;
		

		for (int i = n; i < MAX_SIZE; i++) {

			if (sequenceArray.get(i) != null) {
				return sequenceArray.get(i);
			}

			boolean found = false;
			int count = 1;
			long next = i;

			while (!found) {

				next = next % 2 == 0 ? next / 2 : next * 3 + 1;

				if (next == 1) {
					found = true;
				}
				count++;

			}

			if (sequenceArray.get(i) == null) {
				sequenceArray.put(i, count);
			}

			if (count > max) {
				max = count;
				maxNum = i;
			}

			
			if(count>=globalMax){
				
				globalMax = max;
				maxList.add(i);
				
				System.out.println(i + "\t\t\t" + globalMax);
			}
			
		}

		
		

		return maxNum;
	}


	private static void buildData() {
		
		maxList = new LinkedList<Integer>();

		sequenceArray = new LinkedHashMap<Integer, Integer>();		
		sequenceArray.put(1, 4);
		sequenceArray.put(2, 2);
		globalMax = 4;
		maxList.add(2);
		
		 for (int i = 3; i <= MAX_SIZE; i++) {
			
			 buildDataByN(i);
		 }
		
	}
	

	
}























































	
	
	
	
	
	
	
	
