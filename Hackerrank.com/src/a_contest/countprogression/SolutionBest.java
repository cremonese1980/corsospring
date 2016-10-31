package a_contest.countprogression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SolutionBest {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int dp[][]=new int[1000][300];
		int sequence[]=new int[400000];
		int co[]=new int[1000];
		 
		int sequenceSize=Integer.parseInt(br.readLine());
		int maxInputNumber = 0;
		
		for(int i=1;i<=sequenceSize;i++){
			
			sequence[i]=Integer.parseInt(br.readLine());
			
		    if (sequence[i]>maxInputNumber){
		    	maxInputNumber = sequence[i];
		    }
		}
		        
		int MODULO = 1000000009;
		
		int	ans = 1;
		
		for (int i=1; i<=sequenceSize;i++){     
		        
			ans = ans + ans;
		        
			if (ans >= MODULO){
				
				ans -= MODULO;
			}
		}
		
		ans = ans - sequenceSize - 1;
		
		int d,r;
		
		if (ans<0) {
			
			ans += MODULO;
		}
		for(int i=1;i<=sequenceSize;i++){
			
		    for (d=-maxInputNumber; d<=maxInputNumber;d++){
		    	
		        if (sequence[i]-d>0)
		        if (sequence[i]-d<=maxInputNumber){
		                        r = (dp[sequence[i]-d][d+maxInputNumber]+co[sequence[i]-d]);  
		                        if (r>=MODULO) r-=MODULO;
		                        dp[sequence[i]][d+maxInputNumber] += r;
		                        if (dp[sequence[i]][d+maxInputNumber]>=MODULO) dp[sequence[i]][d+maxInputNumber] -= MODULO;
		                        ans -= r;
		                        if (ans<0) ans += MODULO;
		         }
		     }
		        co[sequence[i]]++;
		}
		BigInteger MODULO_BIG_INTEGER=new BigInteger(String.valueOf(1000000009));
		BigInteger b=new BigInteger("2");
		BigInteger b1=new BigInteger(String.valueOf(ans));
		BigInteger b2=b.modPow(new BigInteger(String.valueOf(sequenceSize)),MODULO_BIG_INTEGER);
		BigInteger b3=b1.mod(MODULO_BIG_INTEGER);
		BigInteger b4=b2.subtract(b3);
		System.out.println(b4.mod(MODULO_BIG_INTEGER));
		} 
	}

