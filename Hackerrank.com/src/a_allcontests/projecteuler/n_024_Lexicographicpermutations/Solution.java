package a_allcontests.projecteuler.n_024_Lexicographicpermutations;

import java.util.Scanner;

public class Solution {
	
	private static final boolean TEST = false;
	
	private static final String WORD = "abcdefghijklm";
//	private static final String WORD = "abcde";
	
	private static final long[] FACTORIAL = new long[]{1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L,
			40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L};
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		long t0 = System.currentTimeMillis();
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
					
			long n = scanner.nextLong();
			
			System.out.println(getSolution2(n, WORD, ""));
		}
		
		scanner.close();
		
		
		long totalTime = System.currentTimeMillis() - t0;
		if(TEST){
			
			System.out.println(totalTime + " ms");
		}
		
		
	}

	private static String getSolution2(long n, String word, String firstPart) {
		
		int charToRemove = n%FACTORIAL[word.length()-1] == 0 ? 
				((int)(n/FACTORIAL[word.length()-1]))-1 : (int)(n/FACTORIAL[word.length()-1]);
				
		firstPart+= word.charAt(charToRemove);
		
		if(firstPart.length() == WORD.length()){
			return firstPart;
		}
		
		String reducedString = removeChar(word, charToRemove);
		
		n = n - (charToRemove*FACTORIAL[word.length()-1]);
		
		return getSolution2(n, reducedString, firstPart);
		
	}

	private static String removeChar(String word, int index) {

		StringBuffer buffer = new StringBuffer();
		
		for (int currIndex = 0; currIndex < word.length(); currIndex++) {

			if(currIndex!=index){
				buffer.append(word.charAt(currIndex));
			}
			
		}
		
		return buffer.toString();
	}

}
