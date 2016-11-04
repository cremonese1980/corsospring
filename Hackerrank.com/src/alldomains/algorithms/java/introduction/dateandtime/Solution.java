package alldomains.algorithms.java.introduction.dateandtime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
    	
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        in.close();
        
        
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DATE, Integer.parseInt(day));
        calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
        String dayOfWeek = dateFormat.format(calendar.getTime());
        System.out.println(dayOfWeek.toUpperCase());
        
        
    }
}
