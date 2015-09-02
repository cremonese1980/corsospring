package countfridays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			final int t = Integer.parseInt(br.readLine());
			
			
			for (int i = 0; i < t; i++) {
				
				System.out.println(countFridays(br.readLine()));
				
			}
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String countFridays(String readLine) {
		
		String[] sl = readLine.split(" ");
		
		Calendar fromCalendar = new GregorianCalendar(Integer.parseInt(sl[2]), Integer.parseInt(sl[1])-1, Integer.parseInt(sl[0]));
		Calendar toCalendar = new GregorianCalendar(Integer.parseInt(sl[5]), Integer.parseInt(sl[4])-1, Integer.parseInt(sl[3]));
		
		long days = TimeUnit.DAYS.convert(toCalendar.getTimeInMillis()-fromCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
		
		int count = 0;
		
		for (int i = 0; i <= days; i++) {
			
			fromCalendar = new GregorianCalendar(Integer.parseInt(sl[2]), Integer.parseInt(sl[1])-1, Integer.parseInt(sl[0]));
			fromCalendar.add(Calendar.DATE, i);
			
			if(fromCalendar.get(Calendar.DATE)==13 &&fromCalendar.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
				count++;
			}
			
		}
		
		return "" + count;
	}

}


