package heightqueen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

	private static final short SIZE = 31;
	
	public static final short SHORT_1 = 1;
	public  static final short SHORT_2 = 2;
	
	private static int countAttempt = 0;
	private static List<Chess> solutions;
	
	public static void main(String[] args) {
		
		solutions = new ArrayList<Chess>();
		
		Chess currentChess;
		Box currentBox;
		
		for (short columnIndex = 1; columnIndex <= SIZE; columnIndex++) {
			
			currentBox = new Box(SHORT_1, columnIndex);
			currentChess = new Chess(SIZE);
			
			putQueens(currentChess, currentBox);
			
		}
		
		System.out.println("Attempts " + countAttempt);
		for (Chess chess : solutions) {
			System.out.println(chess);
		}

	}
	
	
	
	public static void putQueens(Chess chess, Box destinationBox){
		
		if(!chess.putQueen(destinationBox) || chess.isDeadSolution())
		{
			return;
		}
		
		if(solutions.size()>0)
		{
			return;
		}
		
		if(chess.getCount()==SIZE)
		{
			solutions.add(chess);
			return;
		}
		
		Row nextAvailableRow = chess.getNextAvailableRowIndex();
		if(nextAvailableRow==null)
		{	
			System.out.println();
			return;
		}
		countAttempt++;
		Box currBox = null;
		
		for (short columnIndex = 1; columnIndex <= SIZE; columnIndex++) {
			currBox = nextAvailableRow.getBox(columnIndex);
			
			if(currBox.isAvailable())
			{	
				
				putQueens(chess.clone(), currBox.clone());
			}
		}
		
	}

}

class Chess{
	
	public static final short SHORT_1 = 1;
	public  static final short SHORT_2 = 2;
	public static final short SHORT_3 = 3;
	public  static final short SHORT_4 = 4;
	public  static final short SHORT_5 = 5;
	
	private short size;
	private Map<Short,Row> chess;
	private int count = 0;
	private int nextAvailableRowIndex=1;
	
	public Chess(short size) {
		this.size = size;
		chess = new HashMap<Short, Row>();
		
		for (short rowIndex = 1; rowIndex <= size; rowIndex++) {
			chess.put(rowIndex, new Row(rowIndex, size));
		}
	}
	
	public Chess clone(){
		
		Chess clone = new Chess(size);
		for (Short rowIndex : this.chess.keySet()) {
			clone.chess.put(rowIndex, this.chess.get(rowIndex).clone());
		}
		clone.setCount(this.count);
		clone.nextAvailableRowIndex=this.nextAvailableRowIndex;
		return clone;
	}
	
	public Box getNextAvailableBoxIndex() {
		
		if(nextAvailableRowIndex>size || !this.chess.get((short)nextAvailableRowIndex).isAvailable())
		{
			return null;
		}
		
		Row next = this.chess.get((short)nextAvailableRowIndex);
		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			if(next.getBox(columnIndex).isAvailable())
			{
				return next.getBox(columnIndex);
			}
		}
		
		return null;
	}
	
	public boolean isDeadSolution() {
		
		
		for (short rowIndex = (short)nextAvailableRowIndex; rowIndex <= size; rowIndex++) {
			if(this.chess.get(rowIndex).isFullRow())
			{
				return true;
			}
		}
		
		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			boolean deadSol = true;
			for (short rowIndex = (short)1; rowIndex <= size; rowIndex++) {
				
				if(getBox(rowIndex, columnIndex).isQueenPresent()|| getBox(rowIndex, columnIndex).isAvailable()){
					deadSol = false;
					break;
				}
			}
			if(deadSol)
			{
				return true;
			}
		}
		
		return false;
		
	}

	public Row getNextAvailableRowIndex() {
		
		if(nextAvailableRowIndex>size || !this.chess.get((short)nextAvailableRowIndex).isAvailable())
		{
			return null;
		}
		
		Row next = this.chess.get((short)nextAvailableRowIndex);
		
		return next.isAvailable() ? next : null;
		
	}

	public short getSize() {
		return size;
	}
	public Map<Short, Row> getChess() {
		return chess;
	}
	
	public Row getRow(short rowIndex){
		return chess.get(rowIndex);
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public Box getBox(short rowIndex, short columnIndex){
		if(rowIndex<1 || rowIndex>size || columnIndex<1 || columnIndex>size){
			return null;
		}
		
		return chess.get(rowIndex).getBox(columnIndex);
		
	}
	
	public int getCount() {
		return count;
	}

	public boolean putQueen(Box destinationBox){
		
		boolean res = chess.get(destinationBox.getRowIndex()).putQueen(destinationBox.getColumnIndex());
		if (res) {
			setQueen(destinationBox);
			this.count++;
			this.nextAvailableRowIndex++;
			
		}
		return res;
	}

	private void setQueen(Box box) {
		
		chess.get(box.getRowIndex()).getBox(box.getColumnIndex()).setAvailable(false);
		
		Box currentBox;
		
		short rowDiff = 0;
		
		for (short rowIndex = 1; rowIndex <= size; rowIndex++) {
			if(rowIndex==box.getRowIndex()){
				continue;
			}
			
			rowDiff = (short)(box.getRowIndex()-rowIndex);
			rowDiff = (short)(rowDiff<0? -1*rowDiff: rowDiff);
			
			currentBox = getBox(rowIndex, (short)(box.getColumnIndex()+rowDiff));
			if(currentBox!=null){
				currentBox.setAvailable(false);
			}
			currentBox = getBox(rowIndex, (short)(box.getColumnIndex()-rowDiff));
			if(currentBox!=null){
				currentBox.setAvailable(false);
			}
			currentBox = getBox(rowIndex, (short)(box.getColumnIndex()));
			if(currentBox!=null){
				currentBox.setAvailable(false);
			}
			
			
		}
		
		
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("");
		for (Short rowIndex : chess.keySet()) {
			buffer.append(chess.get(rowIndex).toString()+"\n");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		
		Box box1 = new Box(SHORT_1, SHORT_1);
		box1.setAvailable(false);
		box1.setAvailable(true);
		box1.setQueenPresent();
		
		Box box2 = box1.clone();
		Box box3 = new Box(SHORT_2, SHORT_1);
		Row row1 = new Row(SHORT_1, SHORT_2);
		Row row2 = row1.clone();
		row1.putQueen(SHORT_1);

		
		Chess chess1 = new Chess(SHORT_5);
		
		System.out.println(chess1);
		Chess chess2 = chess1.clone();
		System.out.println("equals " + chess1.equals(chess2));
		
		chess1.putQueen(new Box(SHORT_1, SHORT_5));
		System.out.println(chess1);
		System.out.println(chess1.nextAvailableRowIndex);
		System.out.println(chess1.chess.get(SHORT_2));
		System.out.println(chess1.chess.get(SHORT_1).isAvailable());
		System.out.println(chess1.getNextAvailableBoxIndex().getRowIndex() + ", " + chess1.getNextAvailableBoxIndex().getColumnIndex());
		
		chess1.putQueen(new Box(SHORT_2, SHORT_1));
		System.out.println(chess1);
		System.out.println(chess1.nextAvailableRowIndex);
		System.out.println(chess1.chess.get(SHORT_2));
		System.out.println(chess1.chess.get(SHORT_1).isAvailable());
		System.out.println(chess1.getNextAvailableBoxIndex().getRowIndex() + ", " + chess1.getNextAvailableBoxIndex().getColumnIndex());
		
//		chess1.putQueen(new Box(SHORT_2, SHORT_1));
//		System.out.println(chess1);
//		System.out.println(chess1.nextAvailableRowIndex);
		
//		System.out.println(row1.isAvailable());
//		System.out.println(row1.isAvailable());
//		System.out.println(row1);
		
	}
	
	
	
}

class Row{
	
	public static final short SHORT_1 = 1;
	public  static final short SHORT_2 = 2;
	
	private short rowIndex;
	private short size;
	private boolean available = true;
	private Map<Short,Box> row;
	
	public Row(short rowIndex, short size){
		this.rowIndex = rowIndex;
		this.size=size;
		this.row = new HashMap<Short, Box>();
		
		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			row.put(columnIndex, new Box(rowIndex, columnIndex));
		}
	}
	
	public boolean isFullRow() {

		
		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			if(getBox(columnIndex).isAvailable())
			{
				return false;
			}
		}
		return true;
	}

	public void setBox(Box box) {

		row.put(box.getColumnIndex(), box);
		
	}

	public Box getBox(short columnIndex){
		return row.get(columnIndex);
	}
	
	public boolean putQueen(short columnIndexDestination){
		
		if(!available || !getBox(columnIndexDestination).isAvailable()){
			return false;
		}
		
		available = false;
		row.get(columnIndexDestination).setQueenPresent();
		
		for (Short columnIndex : row.keySet()) {
			row.get(columnIndex).setAvailable(false);
		}
		
		return true;
	}
	public void setUnavailable(){
		
	}

	public short getRowIndex() {
		return rowIndex;
	}

	public short getSize() {
		return size;
	}

	public boolean isAvailable() {
		return available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rowIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Row))
			return false;
		Row other = (Row) obj;
		if (rowIndex != other.rowIndex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer= new StringBuffer("");
		for (Short columnIndex : row.keySet()) {
			buffer.append(row.get(columnIndex) + " ");
		}
		return buffer.toString();
	}

	protected Row clone(){
		
		Row clone = new Row(this.rowIndex, this.size);
		clone.available = this.available;
		
		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			clone.row.put(columnIndex, this.getBox(columnIndex).clone());
		}
		
		return clone;
	}
	
	public static void main(String[] args) {
		
		Box box1 = new Box(SHORT_1, SHORT_1);
		box1.setAvailable(false);
		box1.setAvailable(true);
		box1.setQueenPresent();
		
		Box box2 = box1.clone();
		
		
		Box box3 = new Box(SHORT_2, SHORT_1);
		
		
		Row row1 = new Row(SHORT_1, SHORT_2);
		System.out.println(row1);
		
		Row row2 = row1.clone();
		
		System.out.println("equals " + row1.equals(row2));
		System.out.println(row1.isAvailable());
		
		row1.putQueen(SHORT_1);
		System.out.println(row1.isAvailable());

		
		System.out.println(row1);
		
	}
	
}


class Box {
	
	public static final short SHORT_1 = 1;
	public  static final short SHORT_2 = 2;
	
	private short rowIndex;
	private short columnIndex;
	private boolean available = true;
	private boolean queenPresent = false;
	
	public Box(short rowIndex, short columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	public Box clone(){
		
		Box box = new Box(this.getRowIndex(), this.getColumnIndex());
		box.setAvailable(this.available);
		if(this.queenPresent){
			
			box.setQueenPresent();
		}
		return box;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isQueenPresent() {
		return queenPresent;
	}

	public void setQueenPresent() {
		this.queenPresent = true;
		this.available = false;
	}

	public short getRowIndex() {
		return rowIndex;
	}

	public short getColumnIndex() {
		return columnIndex;
	}
	
	public String toString(){
		if(queenPresent){
			return "Q";
		}
		if(!available){
			return "-";
		}
		return "0";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columnIndex;
		result = prime * result + rowIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Box))
			return false;
		Box other = (Box) obj;
		if (columnIndex != other.columnIndex)
			return false;
		if (rowIndex != other.rowIndex)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		
		Box box1 = new Box(SHORT_1, SHORT_1);
		System.out.println(box1);
		box1.setAvailable(false);
		System.out.println(box1);
		box1.setAvailable(true);
		System.out.println(box1);
		box1.setQueenPresent();
		System.out.println(box1);
		
		Box box2 = box1.clone();
		
		System.out.println("must be equal: " + box1.equals(box2) );
		
		System.out.println(box2);
		Box box3 = new Box(SHORT_2, SHORT_1);
		System.out.println("must NOT be equal: " + box1.equals(box3) );
		
	}

	
}