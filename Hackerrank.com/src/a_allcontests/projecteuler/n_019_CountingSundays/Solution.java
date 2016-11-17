package a_allcontests.projecteuler.n_019_CountingSundays;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {
	
public static void main(String[] args) {
		
	long fromYear =0;
	int fromMonth=0;
	int fromDay=0;
	
	long toYear=0;
	int toMonth=0;
	int toDay=0;
	
	int diffYear;
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
					
					
			fromYear = scanner.nextLong();
			fromMonth = scanner.nextInt();
			fromDay = scanner.nextInt();
			
			toYear = scanner.nextLong();
			toMonth = scanner.nextInt();
			toDay = scanner.nextInt();
			
			diffYear = (int)(toYear-fromYear);

			if(fromYear>2500){
				fromYear = 1600 + fromYear%400;
				toYear = fromYear + diffYear;
				
			}
			
			Calendar fromCalendar = new GregorianCalendar();
			fromCalendar.set(Calendar.YEAR, (int)(fromYear));
			fromCalendar.set(Calendar.MONTH, fromMonth-1);
			fromCalendar.set(Calendar.DATE, fromDay);
			fromCalendar.set(Calendar.HOUR, 0);
			fromCalendar.set(Calendar.MINUTE, 0);
			fromCalendar.set(Calendar.SECOND, 0);
			fromCalendar.set(Calendar.MILLISECOND, 0);
			
			Calendar toCalendar = new GregorianCalendar();
			toCalendar.set(Calendar.YEAR, (int)(toYear));
			toCalendar.set(Calendar.MONTH, toMonth-1);
			toCalendar.set(Calendar.DATE, toDay);
			toCalendar.set(Calendar.HOUR, 0);
			toCalendar.set(Calendar.MINUTE, 0);
			toCalendar.set(Calendar.SECOND, 0);
			toCalendar.set(Calendar.MILLISECOND, 0);
			
			System.out.println(getSolution(fromCalendar, toCalendar));
		}
		
		scanner.close();
		
		
		
		
	}

	private static int getSolution(Calendar fromCalendar, Calendar toCalendar) {

		int countSundays = 0;
		toCalendar.add(Calendar.DATE, 1);
		
		int dayDifference =  (int)(((toCalendar.getTimeInMillis() - fromCalendar.getTimeInMillis())/1000)/(60*60*24));
		
		
		for (int i = 0; i <dayDifference; i++) {
			
			
			if(fromCalendar.get(Calendar.DATE) == 1 &&
					fromCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				
				countSundays++;
				
			}
			
			fromCalendar.add(Calendar.DATE, 1);
			
			
		}
		
		return countSundays;
	}


}
