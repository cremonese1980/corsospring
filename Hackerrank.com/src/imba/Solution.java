package imba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
//		BigDecimal bd = new BigDecimal("0.2");
//		System.out.println(bd.toPlainString());
		
//		return;
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			
			final int t = Integer.parseInt(br.readLine());
			final List<BigDecimalCustom> list = new ArrayList<BigDecimalCustom>();
			
			String val= null;
			for (int i = 0; i < t; i++) {
				
				val = br.readLine();
				
				
				list.add(new BigDecimalCustom(new BigDecimal(val), val));
				
				
			}
			
			orderList(list);
			printList(list);
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static void printList(List<BigDecimalCustom> list) {
		
		for (Iterator<BigDecimalCustom> iterator = list.iterator(); iterator.hasNext();) {
			BigDecimalCustom bigDecimal =  iterator.next();
			System.out.println(bigDecimal.getOriginal());
		}
		
	}

	private static void orderList(List<BigDecimalCustom> list) {
		Comparator cmp = Collections.reverseOrder();  
		Collections.sort(list, cmp);
		
	}

	private static String result(final int n) {

		
		
		return null;
	}
	
	
	
}

 class BigDecimalCustom implements Comparable<BigDecimalCustom>{
	
	private final BigDecimal bigDecimal;
	private final String original;
	
	public BigDecimalCustom(final BigDecimal bigDecimal, final String original){
		this.bigDecimal=bigDecimal;
		this.original=original;
	}

	@Override
	public int compareTo(BigDecimalCustom o) {
		return this.bigDecimal.compareTo(o.bigDecimal);
	}

	public String getOriginal() {
		return original;
	}
	
}


