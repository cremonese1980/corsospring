package heightqueensecond.bean;

import java.util.List;

public  abstract class Line {
	
	private int chessSize;
	private int lineNumber;
	private List<Box> boxInLine;
	
	private boolean queenPresent;
	
	
	private int maxIndex;
	private int lineSize;
	

	/*
	 *	Constructors
	 */
	public Line(int chessSize, int lineNumber, int maxIndex, List<Box> boxInLine) {

		this.chessSize = chessSize;
		this.lineNumber = lineNumber;
		this.boxInLine = boxInLine;

		this.maxIndex = checkMaxIndex();
		this.lineSize = checkLineSize();
	}
	
	/*
	 * Abstract methods
	 */

	public abstract int checkMaxIndex();
	
	public abstract int checkLineSize();	
	
	
	/*
	 * Implemented methods
	 */
	public void putQueen(){
		
		queenPresent = true;
	}
	
	public void removeQueen(){
		queenPresent = false;
	}
	
	public  boolean isQueenPresent(){
		return queenPresent;
	}
	
	public int getChessSize() {
		return chessSize;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public List<Box> getBoxInLine() {
		return boxInLine;
	}

	public int getMaxIndex() {
		return maxIndex;
	}
	
	public int getLineSize() {
		return lineSize;
	}
	

}
