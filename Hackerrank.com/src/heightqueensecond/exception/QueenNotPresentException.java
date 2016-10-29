package heightqueensecond.exception;

import heightqueensecond.bean.Box;

public class QueenNotPresentException extends IllegalArgumentException {

	private static final long serialVersionUID = 169488641635607981L;

	public QueenNotPresentException(Box box) {
		super(box.toString());
	}

}
