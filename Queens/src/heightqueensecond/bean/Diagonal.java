package heightqueensecond.bean;

import java.util.List;

public abstract class Diagonal extends Line {

	public Diagonal(int chessSize, int lineNumber, int maxIndex, List<Box> boxInLine) {
		super(chessSize, lineNumber, maxIndex, boxInLine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int checkMaxIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkLineSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
