package heightqueensecond.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chess {
	
	private int size;
	
	private Map<Integer, Point> chess;
	
	private List<Integer> solution;
	
	private List<List<Integer>> solutions;
	
	public Chess(int size) {

		this.size = size;
		
		initChess();
		
		findSolution();
	}
	
	public List<List<Integer>> getSolutions() {
		return solutions;
	}

	public List<Integer> getSolution() {
		return solution;
	}

	private List<Integer> findSolution(){
		
		this.solutions = new ArrayList<>();
		
		int reducedSize = size%2 ==0 ? size/2 : size/2 +1;
		int currentIndex;
		
		for (int currentRow = 0; currentRow < reducedSize; currentRow++) {
			
			for (int currentColumn = 0; currentColumn < reducedSize; currentColumn++) {
				
				currentIndex = getIndex(currentRow, currentColumn);
				
//				List<Integer> currentFree = getFreeList(currentIndex, chess.get(currentIndex).getFreeList());
				
				List<Integer> destinationList = chess.get(currentIndex).getFreeList();
				
				List<Integer> initialSolution = new ArrayList<Integer>();
				initialSolution.add(currentIndex);
				findSolution(cloneList(destinationList), currentIndex, initialSolution);
//				
//				
//				findSolution(currentFree, currentIndex, initialSolution);
//				
//				if(solution!= null && solution.size() == size){
//					this.solutions.add(solution);
//				}
				
				
			}
			
		}
		return null;
		
		
	}

	private void findSolution(List<Integer> destinationList, int currentIndex, List<Integer> solution) {
		
		
		if(solutions.size()>=3){
			return;
		}
		
		
		if(solution.size()==size){
			
			solutions.add(solution);
			
		}else{
			
			
			for (Integer nextDestination : destinationList) {
				
				List<Integer> nextFilteredDestinations = 
						filterDestinations(destinationList, chess.get(nextDestination).getFreeList(),
								currentIndex, nextDestination);
				
				List<Integer> nextSolutionStep = cloneList(solution);
				nextSolutionStep.add(nextDestination);
				
				findSolution(nextFilteredDestinations, nextDestination, nextSolutionStep);
				
			}
			
		}
		
		
	}
	
	
	private List<Integer> filterDestinations(List<Integer> destinationList, 
			List<Integer> nextList, Integer currentDestination, Integer nextDestination) {
		

		List<Integer> result = new ArrayList<Integer>();
		
		for (Integer next : nextList) {
			
			if(next.intValue()!=currentDestination.intValue()
					&& next.intValue()!=nextDestination
					&& destinationList.contains(next)){
				result.add(next);
			}
			
		}
		
		return result;
	}

	public static List<Integer> cloneList(List<Integer> list) {
	    List<Integer> clone = new ArrayList<Integer>(list.size());
	    for (Integer item : list) clone.add(item.intValue());
	    return clone;
	}

	private void initChess() {

		chess = new HashMap<Integer, Point>();
		List<Integer> allNumbers = initAll();
		
		Point currentPoint;
		int currentIndex ;
		List<Integer> currentFreeList;
		
		for (int row = 0; row < size; row++) {

			for (int column = 0; column < size; column++) {
				
				currentIndex = getIndex(row, column);
				currentFreeList = getFreeList(currentIndex, allNumbers);
				currentPoint = new Point(row, column, currentIndex,currentFreeList);
				
				chess.put(currentPoint.getIndex(), currentPoint);
				
			}
			
		}
		
		
	}

	private List<Integer> initAll() {

		List<Integer> all = new ArrayList<Integer>();
		
		for (int i = 0; i < size*size ; i++) {
			
			all.add(i);
		}
		
		return all;
	}

	private int getIndex(int row, int column) {

		return size * row + column; 
		
	}
	
	private List<Integer> getFreeList(int index, List<Integer> permitted){
	
		List<Integer> freeList = new ArrayList<Integer>();
		
		int indexModule = index%size;
		int currentIndexModule;
		
		for (int currentIndex = 0; currentIndex < size*size; currentIndex++) {

			currentIndexModule = currentIndex%size;
			
			if(currentIndexModule != indexModule
					&& (Math.abs(index - currentIndex))%(size+1)!=0
							
					&& 
						((Math.abs(index - currentIndex))%(size-1)!=0 
							|| Math.abs(index - currentIndex)/(size-1)>1)
					&& index/size != currentIndex/size
					&& permitted.contains(currentIndex)
					){
				
				freeList.add(currentIndex);
				
			}
			
		}
		
		return freeList;
		
	}
	
	
	public String printFreeList(){
		
		StringBuffer buffer = new StringBuffer();
		
		for (Integer index : chess.keySet()) {
			
//			buffer.append(chess.get(index).printFreeList() + "\n");
			
			buffer.append(chess.get(index).getFreeListSum() + "\n");
			
		}
		
		return buffer.toString();
		
	}
	
	

}
