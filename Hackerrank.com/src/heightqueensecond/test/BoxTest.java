package heightqueensecond.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import heightqueensecond.bean.Box;
import heightqueensecond.bean.BoxStatus;
import heightqueensecond.bean.Point;
import heightqueensecond.utils.Utils;

public class BoxTest {
	
	private static final Point POINT_0_0 = new Point(0, 0);
	private static final Point POINT_0_7 = new Point(0, Utils.DEFAULT_CHESS_MAX_INDEX);
	private static final Point POINT_7_0 = new Point(Utils.DEFAULT_CHESS_MAX_INDEX, 0);
	private static final Point POINT_7_7 = new Point(Utils.DEFAULT_CHESS_MAX_INDEX, Utils.DEFAULT_CHESS_MAX_INDEX);
	private static final Point POINT_2_2 = new Point(2, 2);
	private static final Point POINT_99_99 = new Point(99, 99);
	
	private static final Box BOX_0_0 = new Box(POINT_0_0, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_0_0_BIS = new Box(POINT_0_0, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_0_7 = new Box(POINT_0_7, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_7_0 = new Box(POINT_7_0, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_7_7 = new Box(POINT_7_7, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_2_2 = new Box(POINT_2_2, Utils.DEFAULT_CHESS_SIZE);
	private static final Box BOX_99_99 = new Box(POINT_99_99, 100);
	
	private static final Box[] BOX_LIST = new Box[]{BOX_0_0, BOX_0_7, BOX_2_2, BOX_7_0, BOX_7_7, BOX_99_99};
	

	@Before
	public void setup(){
		
		for (int i = 0; i < BOX_LIST.length; i++) {
			Box box = BOX_LIST[i];
			
			box.clean();
		}
		
		
//		BigDecimal big = new BigDecimal(Math.pow(2, 1000)).multiply(new BigDecimal(Math.pow(2, 1000)))
//				.multiply(new BigDecimal(Math.pow(2, 1000))).multiply(new BigDecimal(Math.pow(2, 1000)))
//				.multiply(new BigDecimal(Math.pow(2, 1000))).multiply(new BigDecimal(Math.pow(2, 1000)))
//				.multiply(new BigDecimal(Math.pow(2, 1000))).multiply(new BigDecimal(Math.pow(2, 1000)))
//				.multiply(new BigDecimal(Math.pow(2, 1000))).multiply(new BigDecimal(Math.pow(2, 1000)));
		
//		System.out.println(big);
		
	}
	
	
	@Test
	public void testPutQueen() {
		
		System.out.println(BOX_0_0.getDrawConsole());
		
		
		
		assertTrue(!BOX_0_0.isQueenPresent());
		assertTrue(!BOX_0_0.isUnavailable());
		assertTrue(BOX_0_0.isFree());
		
		BOX_0_0.putQueen();
		
		System.out.println(BOX_0_0.getDrawConsole());
		
		assertTrue(BOX_0_0.isQueenPresent());
		assertTrue(!BOX_0_0.isUnavailable());
		assertTrue(!BOX_0_0.isFree());
		
		
	}

	@Test
	public void testSetUnavailable() {
		
		System.out.println(BOX_0_7.getDrawConsole());
		
		assertTrue(!BOX_0_7.isQueenPresent());
		assertTrue(BOX_0_7.isFree());
		assertTrue(!BOX_0_7.isUnavailable());
		assertTrue(!BOX_0_7.isBusy());
		
		BOX_0_7.setUnavailable();
		
		System.out.println(BOX_0_7.getDrawConsole());
		
		assertTrue(!BOX_0_7.isQueenPresent());
		assertTrue(!BOX_0_7.isFree());
		assertTrue(BOX_0_7.isUnavailable());
		assertTrue(BOX_0_7.isBusy());
		
		
	}

	@Test
	public void testClean() {
		
		assertTrue(!BOX_7_0.isQueenPresent());
		assertTrue(BOX_7_0.isFree());
		assertTrue(!BOX_7_0.isUnavailable());
		assertTrue(!BOX_7_0.isBusy());
		
		BOX_7_0.putQueen();
		assertTrue(BOX_7_0.isQueenPresent());
		
		BOX_7_0.clean();
		
		assertTrue(!BOX_7_0.isQueenPresent());
		assertTrue(BOX_7_0.isFree());
		assertTrue(!BOX_7_0.isUnavailable());
		assertTrue(!BOX_7_0.isBusy());
		
		
	}

	@Test
	public void testIsFree() {

		
		assertTrue(!BOX_7_7.isQueenPresent());
		assertTrue(BOX_7_7.isFree());
		assertTrue(!BOX_7_7.isUnavailable());
		assertTrue(!BOX_7_7.isBusy());
		
		BOX_7_7.putQueen();
		assertTrue(!BOX_7_7.isFree());
		
		BOX_7_7.clean();
		
		assertTrue(!BOX_7_7.isQueenPresent());
		assertTrue(BOX_7_7.isFree());
		assertTrue(!BOX_7_7.isUnavailable());
		assertTrue(!BOX_7_7.isBusy());
		
		
	
	}

	@Test
	public void testGetStatus() {
		

		assertTrue(!BOX_2_2.isQueenPresent());
		assertTrue(BOX_2_2.isFree());
		assertTrue(!BOX_2_2.isUnavailable());
		assertTrue(!BOX_2_2.isBusy());
		
		assertTrue(BOX_2_2.getStatus()==BoxStatus.FREE);
		
		BOX_2_2.putQueen();
		assertTrue(BOX_2_2.getStatus()==BoxStatus.QUEEN_PRESENT);
		
		BOX_2_2.clean();
		
		assertTrue(BOX_2_2.getStatus()==BoxStatus.FREE);
		assertTrue(!BOX_2_2.isQueenPresent());
		assertTrue(BOX_2_2.isFree());
		assertTrue(!BOX_2_2.isUnavailable());
		assertTrue(!BOX_2_2.isBusy());
		
		
	}

	@Test
	public void testGetPoint() {
	
		assertTrue(BOX_0_0.getPoint().getColumn() == 0);
		assertTrue(BOX_0_0.getPoint().getRow() == 0);
		assertTrue(BOX_0_0.getPoint().getSum() == 0);
		
		assertTrue(BOX_7_0.getPoint().getColumn() == 0);
		assertTrue(BOX_7_0.getPoint().getRow() == 7);
		assertTrue(BOX_0_7.getPoint().getRow() == 0);
		assertTrue(BOX_2_2.getPoint().getSum() == 4);
		assertTrue(BOX_7_7.getPoint().getSum() == 14);

	}

	@Test
	public void testIsBlack() {
		
		assertTrue(!BOX_7_0.isBlack());
		BOX_7_0.putQueen();
		assertTrue(!BOX_7_0.isBlack());
		
		assertTrue(BOX_0_0.isBlack());
		
		assertTrue(BOX_2_2.isBlack());
	}

	@Test
	public void testIsBorder() {
		
		assertTrue(!BOX_2_2.isBorder());
		assertTrue(BOX_7_7.isBorder());
		assertTrue(BOX_7_0.isBorder());
		assertTrue(BOX_99_99.isBorder());
	}

	@Test
	public void testIsCorner() {
		assertTrue(BOX_99_99.isCorner());
		assertTrue(!BOX_2_2.isCorner());
	}

	@Test
	public void testGetDrawConsole() {
		
		System.out.println(BOX_0_0.getDrawConsole());
		assertTrue(!BOX_0_0.getDrawConsole().contains("Q"));
		
		BOX_0_0.putQueen();
		System.out.println(BOX_0_0.getDrawConsole());
		assertTrue(BOX_0_0.getDrawConsole().contains("Q"));
		
		
		BOX_0_0.clean();
		BOX_0_0.setUnavailable();
		System.out.println(BOX_0_0.getDrawConsole());
		assertTrue(BOX_0_0.getDrawConsole().contains("-"));
	}

	@Test
	public void testEqualsObject() {
		assertTrue(BOX_0_0.equals(BOX_0_0_BIS));
	}
	
	@Test
	public void testGetId() {
		
		assertTrue(BOX_0_0.getId() == 1);
		
		assertTrue(BOX_2_2.getId() == 19);
		
		assertTrue(BOX_7_7.getId() == 64);
	}

}
