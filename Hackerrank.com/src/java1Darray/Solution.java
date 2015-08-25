package java1Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
				
			
			final int t = Integer.parseInt(br.readLine());
			
			String firstLine = null;
			String secondLine = null;
			ArrayCustom arrayCustom = null;
			
			for (int i = 0; i < t; i++) {
				
				firstLine = br.readLine();
				secondLine = br.readLine();
				
				arrayCustom = new ArrayCustom(makeTrack(secondLine, Integer.parseInt(firstLine.split(" ")[0])), Integer.parseInt(firstLine.split(" ")[1]));
				System.out.println(arrayCustom.play());
				
				
			}
			
			
				
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}


	private static int[] makeTrack(final String line, final int n) {

		int[] res = new int[n];
		String[] input = line.split(" ");
		for (int i = 0; i < input.length; i++) {
			res[i] = Integer.parseInt(input[i]);
		}
		
		return res;
	}
	
	
}

 class ArrayCustom {
	
	private static final String YES = "YES";
	private static final String NO = "NO";
	
	private static final int START = 0;
	private static final int FREE = 0;
	 
	private final int[] track;
	private final int jump;
	private final int length;
	private boolean solution = false;
	private List<Integer> done;
	
	public ArrayCustom(final int[] track, final int jump){
		this.track=track;
		this.jump=jump;
		this.length = track.length;
		done = new ArrayList<Integer>();
	}

	public String play() {
		
		move(START);
		
		return solution? YES : NO;		
	}
	
	private void move(final int initPosition){
		
		if(done.contains(new Integer(initPosition))){
			return;
		}
		else{
			done.add(new Integer(initPosition));			
		}
		
		if(initPosition>=length-1 || initPosition+jump>=length){
			solution = true;
			return;
		}
		if(initPosition<0){
			return;
		}
		
		if(initPosition>0 && track[initPosition-1]==FREE){
			move(initPosition-1);
		}
		if(track[initPosition+1]==FREE){
			move(initPosition+1);
		}
		if(track[initPosition+jump]==FREE){
			move(initPosition+jump);
		}
		
		
		
	}
	
	
	
}


