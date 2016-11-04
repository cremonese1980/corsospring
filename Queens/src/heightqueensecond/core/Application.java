package heightqueensecond.core;

import java.math.BigInteger;

public class Application {

	public static int M = 1000000009;
	private static final int MAX = 100;
	
	private static final BigInteger TWO = new BigInteger(String.valueOf(2));
	private static final BigInteger MODULO = new BigInteger(String.valueOf(M));

	public static void main(String args[]) throws Exception {
		
		BigInteger current;
		
		for (int i = 0; i < MAX; i++) {
			
			
			
			
			current = TWO.pow(i);
			
			System.out.println("2^" + i + " = " + current);
			
			System.out.println("2^" + i + " = " + current.mod(MODULO) + " with MODULO");
			
			
		}
		
		
		
		

//		MyThread thrd = new MyThread();
//		thrd.setName("MyThread #1");
//		showThreadStatus(thrd);
//		thrd.start();
//		Thread.sleep(50);
//		showThreadStatus(thrd);
//		thrd.waiting = false;
//		Thread.sleep(50);
//		showThreadStatus(thrd);
//		thrd.notice();
//		Thread.sleep(50);
//		showThreadStatus(thrd);
//		while (thrd.isAlive())
//			System.out.println("alive");
//		showThreadStatus(thrd);
	}

	static void showThreadStatus(Thread thrd) {
		System.out.println(thrd.getName() + "Alive:=" + thrd.isAlive() + "State:=" + thrd.getState());
	}

}
