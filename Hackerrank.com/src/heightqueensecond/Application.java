package heightqueensecond;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import heightqueensecond.bean.Chess;

public class Application {

	private static final int M = 1000000009;
	private static final BigInteger MODULO = new BigInteger(String.valueOf(M));
	
	private static final int DEFAULT_SIZE = 8;

	public static void main(String args[]) throws Exception {
		
		System.out.println(9/5);
		
		System.out.println("Enter chess size [n] or press any key to have default value");
		
		int size;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			size = scanner.nextInt();
			
			
		} catch (Exception e) {
			
			size = DEFAULT_SIZE;
			
		}finally {
			
			scanner.close();
		}	
		
		
		Chess chess = new Chess(size);
		
//		System.out.println(chess.printFreeList());
		
		List<List<Integer>> solutions = chess.getSolutions();
		
		for (Iterator iterator = solutions.iterator(); iterator.hasNext();) {
			List<Integer> solution = (List<Integer>) iterator.next();
			
			System.out.println(solution);
		}
		
		
		
		
		
	}


}
