package a_allcontests.projecteuler.n_022_Namesscores;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	
	private static Map<String, Integer> nameScores = new TreeMap<String, Integer>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numberOfNames = scanner.nextInt();
		
		for (int name = 0; name < numberOfNames; name++) {
					
			String currentName = scanner.next();
			
			addName(currentName);
		}
		
		int numberOfQueries = scanner.nextInt();
		
		for (int q = 0; q < numberOfQueries; q++) {
					
			String currentQuery = scanner.next();
			System.out.println(getSCore(currentQuery));
			
		}
		
		scanner.close();
		
		
		
		
	}

	private static int getSCore(String currentQuery) {

		int position = 1;
		
		for (String name : nameScores.keySet()) {
			
			if(name.equals(currentQuery)){
				
				return position * nameScores.get(currentQuery);
				
			}
			
			position++;
			
		}
		
		return position;
	}

	private static void addName(String currentName) {
		
		nameScores.put(currentName, getNameValue(currentName));
		
		
	}

	private static int getNameValue(String currentName) {

		int nameValue = 0;
		
		for (int currChar = 0; currChar < currentName.length(); currChar++) {
			
			nameValue+= Character.getNumericValue(currentName.charAt(currChar))-9 ;
			
			
		}
		
		return nameValue;
	}
}
