package a_allcontests.projecteuler.n_014_Longest_Collatz;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionBackup1 {

	private static final int MAX_N = 1000000;
	
	private static Map<Long, List<Long>> sequenceMap;
	private static Map<Long, Integer> sequenceArray;
	
	
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
//        long t0 = System.currentTimeMillis();
//        buildData();
//        buildLargest();
//        System.out.println(System.currentTimeMillis()-t0);
        
//        t0 = System.currentTimeMillis();
        buildData2();
        
//        buildLargest();
//        System.out.println(System.currentTimeMillis()-t0);
        
//        sequenceArray = new LinkedHashMap<Long, Integer>();
//		sequenceArray.put(1L, 4);
        
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            
            long solution = getSolution(n);
            
            System.out.println(solution);
        }
        
        in.close();
    }
	
	private static void buildData2() {

		sequenceArray = new LinkedHashMap<Long, Integer>();
		
		List<Long> oneList = new LinkedList<Long>();
		oneList.add(1L);
		oneList.add(4L);
		oneList.add(2L);
		oneList.add(1L);
		
		sequenceArray.put(1L, 4);
		
		for (long n = 1; n <= MAX_N; n++) {

			if(sequenceArray.get(n)!= null){
				
				continue;
			}else{
				
				sequenceArray.put(n, getSequenceSize(n));
			}
		}
		
	}
	
	private static int getSequenceSize(long n) {

		if(n ==1){
			return 4;
		}
		int size = 1;
		
		long next = n%2==0 ? n/2 : n*3+1;
		
		if(next == 1){
			
			return size+1;
		}
		
		int newSize;
		if(sequenceArray.get(next) !=null){
			
			newSize = size + sequenceArray.get(next); 
		}else{
			newSize = size + getSequenceSize(next);
		}
		
		if(n<= MAX_N){
			sequenceArray.put(n, newSize);
			
		}
		
		return newSize;
	}


	private static long getSolution(int n) {
		
		int max = 0;
		long maxNum = 0;
		
//		if(n%2!=0){
//			n--;
//		}
		
		for (long i = n; i >=n/3  ; i = i-1) {

			
			
			if(sequenceArray.get(i)==null){
				sequenceArray.put(i, getSequenceSize(i));
			}
			
			if(sequenceArray.get(i)>max){
				max = sequenceArray.get(i);
				maxNum = i;
			}
			
			
			
		}

		return maxNum;
	}

	
}
