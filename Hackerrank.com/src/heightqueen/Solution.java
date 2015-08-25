package heightqueen;

import java.util.HashMap;
import java.util.Map;


public class Solution {

	private static int countsol = 0;
	public static void main(String[] args) {
		short size = 11;
		Chess chess;

		for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
			chess = new Chess(size);
			chess.putQueen((short)1, columnIndex);
			Chess solution = putQueens(size, (short)2, (short)1, chess.clone());
//			if(solution!=null && solution.getCount()==size){
				System.out.println("S:\n" + solution);
//				break;
//			}
		}

	}
	
	public static Chess putQueens(short size, short rowIndexDestination, short columnIndexDestination, Chess chess){
		countsol++;
		System.out.println(countsol);
//		if(!chess.getRow(rowIndexDestination).isAvailable()){
//			return null;
//		}
		
		for (short row=rowIndexDestination; row <= size; row++) {
			for (short col = columnIndexDestination; col <= size;) {
				
				if(chess.putQueen(row, col)){
					if(rowIndexDestination==size){
						return chess;
					}
					else{
						return putQueens(size, (short)(row+1), (short)1, chess.clone());
					}
				}else if(col<size){
					return putQueens(size, row, (short)(col+1), chess.clone());
				}else{
					return null;
				}
			}
		}
		
		return chess;
		
	}

}

class Chess{
	
	private short size;
	private Map<Short,Row> chess;
	private int count = 0;
	
	public Chess(short size) {
		this.size = size;
		chess = new HashMap<Short, Row>();
		
		for (short rowIndex = 1; rowIndex <= size; rowIndex++) {
			chess.put(rowIndex, new Row(rowIndex, size));
		}
	}
	
	public Chess clone(){
		Row row;
		Chess chess = new Chess(size);
		for (Short rowIndex : this.chess.keySet()) {
			row = this.chess.get(rowIndex);
			for (short columnIndex = 1; columnIndex <= size; columnIndex++) {
				
				chess.setBox(row.getBox(columnIndex).clone());
			}
		}
		chess.setCount(this.count);
		return chess;
	}
	
	private void setBox(Box box) {

		chess.get(box.getRowIndex()).setBox(box);
		
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

	public boolean putQueen(short rowIndex, short columnIndex){
		boolean res = chess.get(rowIndex).putQueen(columnIndex);
		if (res) {
			setUnavailable(rowIndex, columnIndex);
			this.count++;
		}
		return res;
	}
	private void setUnavailable(short rowIndexDestination, short columnIndexDestination) {
		
		for (Short rowIndex : chess.keySet()) {
			chess.get(rowIndex).getBox(columnIndexDestination).setAvailable(false);
		}
		
		Box currentBox;
		
		short rowDiff = 0;
		
		for (short rowIndex = 1; rowIndex <= size; rowIndex++) {
			if(rowIndex==rowIndexDestination){
				continue;
			}
			
			rowDiff = (short)(rowIndexDestination-rowIndex);
			rowDiff = (short)(rowDiff<0? -1*rowDiff: rowDiff);
			
			currentBox = getBox(rowIndex, (short)(columnIndexDestination+rowDiff));
			if(currentBox!=null){
				currentBox.setAvailable(false);
			}
			currentBox = getBox(rowIndex, (short)(columnIndexDestination-rowDiff));
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
	
	
	
}

class Row{
	
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
	
}


class Box {
	
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

	
}