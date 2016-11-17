package a_allcontests.projecteuler.n_017_NumbertoWords;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static final String ZERO = "Zero";
	private static final String ONE = "One";
	private static final String TWO = "Two";
	private static final String THREE = "Three";
	private static final String FOUR = "Four";
	private static final String FIVE = "Five";
	private static final String SIX = "Six";
	private static final String SEVEN = "Seven";
	private static final String EIGHT = "Eight";
	private static final String NINE = "Nine";
	private static final String TEN = "Ten";
	private static final String ELEVEN = "Eleven";
	private static final String TWELVE = "Twelve";
	private static final String THIRTEEN = "Thirteen";
	private static final String FOURTEEN = "Fourteen";
	private static final String FIFTEEN = "Fifteen";
	private static final String SIXTEEN = "Sixteen";
	private static final String SEVENTEEN = "Seventeen";
	private static final String EIGHTEEN = "Eighteen";
	private static final String NINETEEN = "Nineteen";
	private static final String TWENTY = "Twenty";
	private static final String THIRTY = "Thirty";
	private static final String FOURTY = "Forty";
	private static final String FIFTY = "Fifty";
	private static final String SIXTY = "Sixty";
	private static final String SEVENTY = "Seventy";
	private static final String EIGHTY = "Eighty";
	private static final String NINETY = "Ninety";
	private static final String HUNDRED = "Hundred";
	private static final String THOUSAND = "Thousand";
	private static final String MILLION = "Million";
	private static final String BILLION = "Billion";
	private static final String TRILLION = "Trillion";
	
	private static final Map<Long, String> NUMBER_MAP;
	
	static{
		NUMBER_MAP = new HashMap<Long, String>();
		
		NUMBER_MAP.put(0L, ZERO);
		NUMBER_MAP.put(1L, ONE);
		NUMBER_MAP.put(2L, TWO);
		NUMBER_MAP.put(3L, THREE);
		NUMBER_MAP.put(4L, FOUR);
		NUMBER_MAP.put(5L, FIVE);
		NUMBER_MAP.put(6L, SIX);
		NUMBER_MAP.put(7L, SEVEN);
		NUMBER_MAP.put(8L, EIGHT);
		NUMBER_MAP.put(9L, NINE);
		NUMBER_MAP.put(10L, TEN);
		NUMBER_MAP.put(11L, ELEVEN);
		NUMBER_MAP.put(12L, TWELVE);
		NUMBER_MAP.put(13L, THIRTEEN);
		NUMBER_MAP.put(14L, FOURTEEN);
		NUMBER_MAP.put(15L, FIFTEEN);
		NUMBER_MAP.put(16L, SIXTEEN);
		NUMBER_MAP.put(17L, SEVENTEEN);
		NUMBER_MAP.put(18L, EIGHTEEN);
		NUMBER_MAP.put(19L, NINETEEN);
		NUMBER_MAP.put(20L, TWENTY);
		NUMBER_MAP.put(30L, THIRTY);
		NUMBER_MAP.put(40L, FOURTY);
		NUMBER_MAP.put(50L, FIFTY);
		NUMBER_MAP.put(60L, SIXTY);
		NUMBER_MAP.put(70L, SEVENTY);
		NUMBER_MAP.put(80L, EIGHTY);
		NUMBER_MAP.put(90L, NINETY);
		NUMBER_MAP.put(100L, HUNDRED);
		NUMBER_MAP.put(1000L, THOUSAND);
		NUMBER_MAP.put(1000000L, MILLION);
		NUMBER_MAP.put(1000000000L, BILLION);
		NUMBER_MAP.put(1000000000000L, TRILLION);
	}
	
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {

			long n = scanner.nextLong();
			
			System.out.println(getSolution(n));
			
			
		}
		
		scanner.close();
		
	}

	private static String getSolution(long n) {
		
		if(n==0){
			return ZERO;
		}

		StringBuffer result = new StringBuffer();
		
		String nAsString = String.valueOf(n);
		
		int groupSize = 3;

		int lastGroupSize =  nAsString.length()%groupSize!=0 ? nAsString.length()%groupSize : groupSize;
		
		int numberOfGroups = nAsString.length()%groupSize == 0 ? nAsString.length()/groupSize : 1 +nAsString.length()/groupSize; 
		
		int  fromIndex = 0;
		int group = Integer.parseInt(nAsString.substring(fromIndex, fromIndex + lastGroupSize));
		
		result.append(numToString(group, numberOfGroups-1));
		
		for (int i = numberOfGroups-2; i >=0 ; i--) {

			fromIndex = nAsString.length()-groupSize*(1+i);
			group = Integer.parseInt(nAsString.substring(fromIndex, fromIndex + groupSize));
			
			result.append(numToString(group, i));
			
		}
		
		
		return putSpaces(result.toString());
		
	}

	private static String putSpaces(String original) {

		StringBuffer buffer = new StringBuffer();
		
		boolean first = true;
		String space = "";
		
		for (int j = 0; j < original.length(); j++) {

			if(Character.isUpperCase(original.charAt(j))) {
				
				if(first){
					first = false;
				}else{

					space = " ";
					
				}
			}else{
				space = "";
			}
			
			buffer.append(space + original.charAt(j));
			
			
		}
		
		
		return buffer.toString();
	}

	private static String numToString(long num, int groupNumber) {
		
		if(num==0){
			return "";
		}
		
		StringBuffer buffer = new StringBuffer();
		
		long hundreds = num - num%100;
		long dec = num - hundreds;
		hundreds = hundreds/100;
		long unit = dec%10;
		
		if(hundreds>0){
			buffer.append(NUMBER_MAP.get(hundreds) + HUNDRED);
		}
		
		
		if(dec>0){
			
			if(dec<=20){
				buffer.append(NUMBER_MAP.get(dec));
			}else{
				
				dec = dec - unit;
				buffer.append(NUMBER_MAP.get(dec));
				if(unit>0){
					
					buffer.append(NUMBER_MAP.get(unit));
				}
			}
			
		}else if(unit>0){
			
			buffer.append(NUMBER_MAP.get(unit));
		}
		
		switch (groupNumber) {
		case 0:
			
			break;
			
		case 1:
			buffer.append(THOUSAND);
			break;
			
		case 2:
			buffer.append(MILLION);
			break;
			
		case 3:
			buffer.append(BILLION);
			break;
			
		case 4:
			buffer.append(TRILLION);
			break;

		default:
			break;
		}
		
		
		return buffer.toString();
	}

}
