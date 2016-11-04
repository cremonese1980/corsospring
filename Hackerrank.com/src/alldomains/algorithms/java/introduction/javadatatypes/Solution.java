package alldomains.algorithms.java.introduction.javadatatypes;

import java.util.*;
import java.io.*;



class Solution{
    public static void main(String []argh)
    {



        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++){

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
            
                if(x>=-128 && x<=127){//8
                	System.out.println("* byte");
                }
                if(x>=-(int)(Math.pow(2, 15)) && x<=(int)(Math.pow(2, 15)-1)){//16
                	System.out.println("* short");
                }
                if(x>=-(int)(Math.pow(2, 31)) -1 && x<=(int)(Math.pow(2, 31)-1)){//32
                	System.out.println("* int");
                }
                if(x>=-(long)(Math.pow(2, 63)) -1 && x<=(long)(Math.pow(2, 63))){//64
                	System.out.println("* long");
                }
                
            
            
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
        
        sc.close();
    }
}
