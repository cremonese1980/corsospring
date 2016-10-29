package heightqueensecond.exception;

import heightqueensecond.bean.Box;

public class BoxUnavailableException extends IllegalArgumentException {

	private static final long serialVersionUID = 169488641635607981L;

	public BoxUnavailableException(Box box) {
		super(box.toString());
	}

}
