package libraryfine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			DateFormat readFormat = new SimpleDateFormat( "dd MM yyyy");
		
			Date actualDate=null;
			Date expectedDate=null;
			try {
				actualDate = readFormat.parse(br.readLine());
				expectedDate = readFormat.parse(br.readLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Calendar actualCalendar = new GregorianCalendar();
			actualCalendar.setTime(actualDate);
			
			Calendar expectedCalendar = new GregorianCalendar();
			expectedCalendar.setTime(expectedDate);
			
			int fine = 0;
			
			if(actualDate.after(expectedDate))
			{
				if(actualCalendar.get(Calendar.YEAR)==expectedCalendar.get(Calendar.YEAR))
				{
					if(actualCalendar.get(Calendar.MONTH)==expectedCalendar.get(Calendar.MONTH))
					{
						fine = 15* (actualCalendar.get(Calendar.DATE)-expectedCalendar.get(Calendar.DATE));
					}
					else
					{
						fine = 500 * (actualCalendar.get(Calendar.MONTH)-expectedCalendar.get(Calendar.MONTH));
					}
				}
				else
				{
					fine = 10000;
				}
			}
			
			System.out.println(fine);
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
}


