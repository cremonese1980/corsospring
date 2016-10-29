package heightqueensecond.bean;

import heightqueensecond.exception.BoxUnavailableException;
import heightqueensecond.exception.QueenNotPresentException;
import heightqueensecond.utils.Utils;

public class Box {
	
	
	private Point point;
	private int id;
	
	private BoxStatus status = BoxStatus.FREE;
	
	private boolean black;
	private boolean border;
	private boolean corner;
	
	private String rgbColor;
	
	private String drawConsole;

	public Box(Point point, int chessSize) {

		this.point = point;
		
		initBox(chessSize);
	}

	public void clean(){
		status = BoxStatus.FREE;
	}
	
	public void putQueen() throws BoxUnavailableException{
		
		if(!isFree()){
			throw new BoxUnavailableException(this);
		}
		setStatus(BoxStatus.QUEEN_PRESENT);
	}
	
	public void setUnavailable() throws BoxUnavailableException{
		
		if(!isFree()){
			throw new BoxUnavailableException(this);
		}
		setStatus(BoxStatus.UNAVAILABLE);
	}
	
	public void removeQueen() throws QueenNotPresentException{
		
		if(!isQueenPresent()){
			throw new QueenNotPresentException(this);
		}
		setStatus(BoxStatus.FREE);
	}
	

	public boolean isUnavailable(){
		return status == BoxStatus.UNAVAILABLE;
	}
	
	public boolean isFree(){
		return status == BoxStatus.FREE;
	}
	
	public boolean isQueenPresent(){
		return status == BoxStatus.QUEEN_PRESENT;
	}
	
	public boolean isBusy(){
		return status!= BoxStatus.FREE;
	}
	
	public BoxStatus getStatus() {
		return status;
	}

	public Point getPoint(){
		return point;
	}
	
	public boolean isBlack() {
		return black;
	}

	public boolean isBorder() {
		return border;
	}

	public boolean isCorner() {
		return corner;
	}

	public String getRgbColor() {
		return rgbColor;
	}
	

	public String getDrawConsole() {
		return drawConsole;
	}
	
	public int getId() {
		return id;
	}

	private void initBox(int chessSize) {

		black = point.getSum() % 2 == 0;
		
		border = checkIfBorder(chessSize);
		
		corner = checkIfCorner(chessSize);
		
		drawConsole = buildDrawConsole();
		
		id = checkId(chessSize);
	}

	private String buildDrawConsole() {

		switch (status) {
		
		case FREE:
			return Utils.BOX_DRAW_EMPTY;
			
		case UNAVAILABLE:
			return Utils.BOX_DRAW_UNAVAILABLE;
			
		case QUEEN_PRESENT:
			return Utils.BOX_DRAW_QUEEN;

		default:
			return null;
		}
		
	}

	private boolean checkIfBorder(int chessSize) {

		return point.getRow() == 0
				|| point.getRow() == chessSize-1
				|| point.getColumn() == 0
				|| point.getColumn() == chessSize-1;
	}

	private boolean checkIfCorner(int chessSize) {

		return border 
				&& (point.getSum() == 0
				|| point.getSum() == chessSize-1
				|| point.getSum() == (chessSize-1)*2 );
	}
	
	private void setStatus(BoxStatus status){
		
		this.status = status;
		drawConsole = buildDrawConsole();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}
	
	private int checkId(int chessSize) {
		return point.getRow() * chessSize + point.getRow() + 1;
	}
	

}
