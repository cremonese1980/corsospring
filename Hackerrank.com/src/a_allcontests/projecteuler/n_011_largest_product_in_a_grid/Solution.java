package a_allcontests.projecteuler.n_011_largest_product_in_a_grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static final int SIDE_SIZE = 20;
	private static final int SIZE = 4;
	private static int[][] grid;
	
	private static Map<Integer, List<Integer>> mainDiagonal;
	private static Map<Integer, List<Integer>> secondaryDiagonal;
	

    public static void main(String[] args) {
    	
    	mainDiagonal = new HashMap<Integer, List<Integer>>();
    	secondaryDiagonal= new HashMap<Integer, List<Integer>>();
    	
        Scanner in = new Scanner(System.in);
        
        grid = new int[SIDE_SIZE][SIDE_SIZE];
        
        for(int grid_i=0; grid_i < SIDE_SIZE; grid_i++){
        	
        	
            for(int grid_j=0; grid_j < SIDE_SIZE; grid_j++){
            	
                grid[grid_i][grid_j] = in.nextInt();
                
                addToDiagonal(grid_i, grid_j);
                
                
                
            }
        }
        
        int solution = getSolution();
        
        System.out.println(solution);
        
        in.close();
    }

	private static void addToDiagonal(int row, int column) {

		if(mainDiagonal.get(row-column) == null){
			mainDiagonal.put(row-column, new ArrayList<Integer>());;
		}
			
		mainDiagonal.get(row-column).add(grid[row][column]);
		
		
		if(secondaryDiagonal.get(row+column) == null){
			secondaryDiagonal.put(row+column, new ArrayList<Integer>());;
		}
			
		secondaryDiagonal.get(row+column).add(grid[row][column]);
		
		
		
	}

	private static int getSolution() {
		
		int maxColumnProduct = getMaxColumnProduct();
		int maxRowProduct = getmaxRowProduct();
		
		int max = Math.max(maxRowProduct, maxColumnProduct);
		
		int maxMainDiagonalProduct = getMaxMainDiagonalProduct();
		max = Math.max(max, maxMainDiagonalProduct);
		
		int maxSecondaryDiagonalProduct = getMaxSecondaryDiagonalProduct();
		max = Math.max(max, maxSecondaryDiagonalProduct);
		
		return max;
	}

	private static int getMaxSecondaryDiagonalProduct() {
		
		int max = 0;
		
		for (Integer diagonalAddress : secondaryDiagonal.keySet()) {
			
			int localMax = getMaxProductInDiagonal(secondaryDiagonal.get(diagonalAddress));
			
			if(localMax>max){
				max = localMax;
			}
			
		}

		
		return max;
	}

	private static int getMaxMainDiagonalProduct() {
		
		int max = 0;
		
		for (Integer diagonalAddress : mainDiagonal.keySet()) {
			
			int localMax = getMaxProductInDiagonal(mainDiagonal.get(diagonalAddress));
			
			if(localMax>max){
				max = localMax;
			}
			
		}

		
		return max;
	}

	private static int getmaxRowProduct() {
		
		int max = 0;
		
		for(int grid_i=0; grid_i < SIDE_SIZE; grid_i++){
        	
        	
            for(int grid_j=0; grid_j < SIDE_SIZE - SIZE + 1; grid_j++){
            	
            	
            	int localMax = 1;
            	
                for (int k = grid_j; k < grid_j + SIZE; k++) {
					

                	localMax*= grid[grid_i][k];
                			
                	
				}
                
                if(localMax> max){
                	max = localMax;
                }
                
                
            }
        }
		
		return max;
	}

	private static int getMaxColumnProduct() {
		
		int max = 0;
		
		for(int column=0; column < SIDE_SIZE; column++){
        	
        	
            for(int row=0; row < SIDE_SIZE - SIZE + 1; row++){
            	
            	
            	int localMax = 1;
            	
                for (int k = row; k < row + SIZE; k++) {
					

                	localMax*= grid[k][column];
                			
                	
				}
                
                if(localMax> max){
                	max = localMax;
                }
                
                
            }
        }
		
		return max;
	}
	
	
	private static int getMaxProductInDiagonal(List<Integer> diagonal){
		
		int max = 0;
		
		for(int index=0; index < diagonal.size() - SIZE + 1; index++){
        	
        	
        	int localMax = 1;
        	
            for (int k = index; k < index + SIZE; k++) {
				

            	localMax*= diagonal.get(k);
            			
            	
			}
            
            if(localMax> max){
            	max = localMax;
            }
            
            
        }
		
		return max;
	}
	
}
