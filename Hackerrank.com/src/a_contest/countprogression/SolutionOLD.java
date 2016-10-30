package a_contest.countprogression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionOLD {
	
	private static final int MAX_DIFFERENCE = 100;
	
	private static final BigInteger MODULO = new BigInteger(String.valueOf(1000000009)) ;
	
    public static void main(String[] args) {
    	
    	
    	
        Scanner scanner = new Scanner(System.in);
        
        int sequenceSize = scanner.nextInt();
        int[] sequence = new int[sequenceSize];
        int[] countMap = new int[101];
        
        for (int i = 0; i < sequence.length; i++) {

        	sequence[i] = scanner.nextInt();
        	
        	countMap[sequence[i]]++;
		}
        
        scanner.close();
        
        BigInteger zeroProgressions = countZeroProgressions(countMap);
        BigInteger sequencePlusOne = BigInteger.ONE.add(new BigInteger(String.valueOf(sequenceSize)));
        BigInteger combinations = getCouples(sequenceSize);
        BigInteger result = getResult(sequence);
        
        result = result.add(sequencePlusOne)
        		.add(combinations)
        		.add(zeroProgressions)
        		.mod(new BigInteger(String.valueOf(MODULO)));
        
        
        System.out.println(result.mod(MODULO));
        
    }

	private static BigInteger countZeroProgressions(int[] countMap) {

		BigInteger zeroProgressions = BigInteger.ZERO;
		
		for (int i = 1; i < countMap.length; i++) {
			
			zeroProgressions = zeroProgressions.add(allCombinations(countMap[i]));
			
			
		}
		
		return zeroProgressions;
	}

	private static BigInteger allCombinations(int combinationSize) {

		if(combinationSize <= 2){
			
			return BigInteger.ZERO;
		}
		if(combinationSize == 2){
			
			return BigInteger.ONE;
		}
		
		BigInteger allCombinations = BigInteger.ONE;
		
		for (int i = 3; i < combinationSize; i++) {
			
			allCombinations = allCombinations.add(getCombination(combinationSize, i));
		}
		
		
		return allCombinations;
	}

	private static BigInteger getCombination(int n, int k) {

		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;
		
		for (int i = n-k+1; i <= n; i++) {
			
			numerator = numerator.multiply(new BigInteger(String.valueOf(i)));
			
		}
		for (int i = 2; i <= k; i++) {
			
			denominator = denominator.multiply(new BigInteger(String.valueOf(i)));
			
		}
		
		return numerator.divide(denominator);
	}

	private static BigInteger getResult(int[] sequence) {
    	
    	BigInteger totalCount = BigInteger.ZERO;
    	
    	for (int currentDifference = -1*MAX_DIFFERENCE; currentDifference <= MAX_DIFFERENCE; currentDifference++) {
			
    		if(currentDifference == 0){
    			continue;
    		}
    		
    		totalCount = totalCount.add(countProgressionsByDifference(sequence, currentDifference));    		
    		
		}
    	
		return totalCount;
	}



	private static BigInteger countProgressionsByDifference(int[] sequence, int difference) {

		List<Integer> currentProgression;
		
		BigInteger countProgressionsByDifference = BigInteger.ZERO;
		boolean firstAdded;
		
		for (int i = 0; i < sequence.length - 1; i++) {
			
			firstAdded = false;
			int currentProgressionSize = 0;
			currentProgression = new ArrayList<Integer>();
			
		
			for (int j = i+1; j < sequence.length; j++) {
				
				int n = firstAdded ? currentProgressionSize+1 : 2;
				
				if(belongsToProgression(sequence[i], sequence[j], n, difference)){
				
					if(!firstAdded){
						currentProgressionSize++;
						currentProgression.add(sequence[i]);
						firstAdded = true;
					}
					
					currentProgressionSize++;
					currentProgression.add(sequence[j]);
				}
				
			}
			
			if(currentProgressionSize>2){
				
//				countProgressionsByDifference = 
//						countProgressionsByDifference.add
//						(getSubProgressionsSize(currentProgressionSize)) ;//TODO  Subprogression?
				
				
				countProgressionsByDifference = 
						countProgressionsByDifference.add
						((new BigInteger(String.valueOf(currentProgressionSize-2)))) ;//TODO  Subprogression?
//				printProgression(currentProgression);
			}
			
			
		}
		
		
		return countProgressionsByDifference;
	}
	
	private static BigInteger getSubProgressionsSize(int originalProgressionSize) {

		int n = originalProgressionSize - 2;	
		int sum = (n*n + n)/2;
		
		return new BigInteger(String.valueOf(sum));
	}

	private static boolean belongsToProgression(int b_1, int b_n_toCheck, int n, int difference){
		
		int b_n = b_1 + (n-1)*difference;
		
		return b_n == b_n_toCheck;
		
	}

	private static void printProgression(List<Integer> currentProgression) {
		
		int index = 0;
		for (Integer integer : currentProgression) {
			
			System.out.print(integer);
			
			if(index== currentProgression.size()-1){
				System.out.println("");
			}else{
				System.out.print(", ");
			}
			index++;
		}
		
	}
	
	private static BigInteger getCouples(int n) {

		
		
		return new BigInteger(String.valueOf(n))
				.multiply(new BigInteger(String.valueOf(n-1)))
				.divide(new BigInteger(String.valueOf(2)));
	}

}


