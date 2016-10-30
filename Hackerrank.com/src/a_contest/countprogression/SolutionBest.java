
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionBest {
	
	private static final int MAX_DIFFERENCE = 100;
	
	private static final BigInteger MODULO = new BigInteger(String.valueOf(1000000009)) ;
	
    public static void main(String[] args) {
    	
    	
    	
        Scanner scanner = new Scanner(System.in);
        
        int sequenceSize = scanner.nextInt();
        int[] sequence = new int[sequenceSize];
        
        for (int i = 0; i < sequence.length; i++) {

        	sequence[i] = scanner.nextInt();
        	
		}
        
        scanner.close();
        
        BigInteger sequencePlusOne = BigInteger.ONE.add(new BigInteger(String.valueOf(sequenceSize)));
        BigInteger combinations = getCouples(sequenceSize);
        BigInteger result = getResult(sequence);
        
        result = result.add(sequencePlusOne).add(combinations).mod(new BigInteger(String.valueOf(MODULO)));
        
        
        System.out.println(result.mod(MODULO));
        
    }

	
    
    private static BigInteger getResult(int[] sequence) {
    	
    	BigInteger totalCount = BigInteger.ZERO;
    	
    	for (int currentDifference = -1*MAX_DIFFERENCE; currentDifference <= MAX_DIFFERENCE; currentDifference++) {
			
    		totalCount = totalCount.add(countProgressionsByDifference(sequence, currentDifference));    		
    		
		}
    	
		return totalCount;
	}



	private static BigInteger countProgressionsByDifference(int[] sequence, int difference) {

//		List<Integer> currentProgression;
		
		BigInteger countProgressionsByDifference = BigInteger.ZERO;
		boolean firstAdded;
		
		for (int i = 0; i < sequence.length - 1; i++) {
			
			firstAdded = false;
			int currentProgressionSize = 0;
//			currentProgression = new ArrayList<Integer>();
			
		
			for (int j = i+1; j < sequence.length; j++) {
				
				int n = firstAdded ? currentProgressionSize+1 : 2;
				
				if(belongsToProgression(sequence[i], sequence[j], n, difference)){
				
					if(!firstAdded){
						currentProgressionSize++;
//						currentProgression.add(sequence[i]);
						firstAdded = true;
					}
					
					currentProgressionSize++;
//					currentProgression.add(sequence[j]);
				}
				
			}
			
			if(currentProgressionSize>2){
				
				countProgressionsByDifference = 
						countProgressionsByDifference.add
						(new BigInteger(String.valueOf(currentProgressionSize-2))) ;//TODO  Subprogression?
				
//				countProgressionsByDifference = 
//						countProgressionsByDifference.add
//						(BigInteger.ONE) ;//TODO  Subprogression?
//				printProgression(currentProgression);
			}
			
			
		}
		
		
		return countProgressionsByDifference;
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


