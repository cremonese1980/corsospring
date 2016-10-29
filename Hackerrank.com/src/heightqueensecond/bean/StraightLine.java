package heightqueensecond.bean;

import java.util.List;

public abstract class StraightLine extends Line {
	
	private boolean border;

	/*
	 * Constructors
	 */
	public StraightLine(int chessSize, int lineNumber, int maxIndex, List<Box> boxInLine) {
		super(chessSize, lineNumber, maxIndex, boxInLine);
		
		border = checkIfBorder();
	}

	/*
	 * Abstract methods
	 */

	public abstract Box nextAvailable();
	
	
	/*
	 * Public methods
	 */
	public boolean isBorder() {
		
		return border;
	}
	
	/*
	 * Override methods
	 */
	
	@Override
	public int checkMaxIndex() {
		
		return getChessSize() -1;
	}

	@Override
	public int checkLineSize() {

		return getMaxIndex();
	}
	
	
	
	
	
	
	
/*
 * 	Private Methods
 */

	private boolean checkIfBorder() {
		
		return getLineNumber() == 0
				|| getLineNumber() == getMaxIndex();
	}

}
