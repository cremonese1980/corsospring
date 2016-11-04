package heightqueensecond.bean;

import java.util.Iterator;
import java.util.List;

public class Point {
	
	private int row;
	private int column;
	private int index;
	private List<Integer> freeList;
	
	private int pow;
	
	private int freeListSum;
	
	
	public Point(int row, int column, int index, List<Integer> freeList) {
		
		this.row = row;
		this.column = column;
		this.index = index;
		this.freeList = freeList;
//		this.pow = (int)Math.pow(2, index);
//		
//		
//		
//		for (Iterator<Integer> iterator = freeList.iterator(); iterator.hasNext();) {
//			Integer integer = iterator.next();
//			
//			freeListSum+= (int)Math.pow(2, integer);
//			
//			
//			
//		}
	}

	public Point(int row, int column) {

		this.row = row;
		this.column = column;
		
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public int getSum(){
		return row + column;
	}

	public int getIndex() {
		return index;
	}
	
	public int getPow(){
		return this.pow;
	}
	

	public int getFreeListSum() {
		return freeListSum;
	}

	public List<Integer> getFreeList() {
		return freeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
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
		Point other = (Point) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public String printFreeList() {
		
		StringBuffer buffer = new StringBuffer("Index [" + index + "] - Free list: ");
		
		for (Integer integer : freeList) {
		
				buffer.append(integer + ",");
			
		}
		
		
//		buffer.replace(buffer.lastIndexOf(","), buffer.lastIndexOf(","), "") ;

		return    buffer.toString();
	}
	
	

}
