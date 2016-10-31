package a_contest.countprogression;

import java.io.*;
import java.util.*;

public class Solution_ {
	
  public static int MODULO = 1000000009;
  
  public static int MAX_VALUE = 5;

  public static void main(String[] args) throws IOException {
    
    Scanner scanner = new Scanner(System.in);

    int sequenceSize = scanner.nextInt();
    
    long ans = sequenceSize+1;
    
//    long[][] nways = new long[205][205];
//    long[][] next = new long[205][205];
    
    long[][] nways = new long[2*MAX_VALUE+1][2*MAX_VALUE+1];
    long[][] next = new long[2*MAX_VALUE+1][2*MAX_VALUE+1];
    
    // last, diff
    for (int i = 0; i < sequenceSize; i++) {
    	
      int currentNumber = scanner.nextInt();
      
      System.arraycopy(nways[currentNumber], 0, next[currentNumber], 0, next.length);
      
      for (int currentDifference = -3; currentDifference <= 3; currentDifference++) {
    	  
        int prev = currentNumber + currentDifference;
        
        next[currentNumber][currentDifference+MAX_VALUE]++;
//        if (next[currentNumber][currentDifference+MAX_VALUE] >= MODULO) next[currentNumber][currentDifference+MAX_VALUE] -= MODULO;
        if (prev < 0 || prev > MAX_VALUE) continue;
        next[currentNumber][currentDifference+MAX_VALUE] += nways[prev][currentDifference+MAX_VALUE];
//        if (next[currentNumber][currentDifference+MAX_VALUE] >= MODULO) next[currentNumber][currentDifference+MAX_VALUE] -= MODULO;
        ans += nways[prev][currentDifference+MAX_VALUE];
//        if (ans >= MODULO) ans -= MODULO;
      }
      System.arraycopy(next[currentNumber], 0, nways[currentNumber], 0, next.length);
    }

    scanner.close();
    System.out.println(ans);
    
    System.exit(0);
  }



}