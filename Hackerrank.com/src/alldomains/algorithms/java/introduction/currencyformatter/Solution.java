package alldomains.algorithms.java.introduction.currencyformatter;
import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        double payment = scanner.nextDouble();
        
        scanner.close();
        
        
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + numberFormat.format(payment));
        
        numberFormat = NumberFormat.getCurrencyInstance(new Locale("EN", "IN"));
        System.out.println("India: " + numberFormat.format(payment));
        
        numberFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + numberFormat.format(payment));
        
        numberFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + numberFormat.format(payment));
    }
}
