package timeconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			DateFormat readFormat = new SimpleDateFormat( "hh:mm:ssaa");
			DateFormat writeFormat = new SimpleDateFormat( "HH:mm:ss");
		
			String inputDate = br.readLine();
			Date date;
			try {
				date = readFormat.parse(inputDate);
				System.out.println(writeFormat.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
}


