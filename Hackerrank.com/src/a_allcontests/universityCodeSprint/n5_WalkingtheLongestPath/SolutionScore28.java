package a_allcontests.universityCodeSprint.n5_WalkingtheLongestPath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SolutionScore28 {
	
	
	private static Tree tree;
	private static List<Node> bestSolution = new LinkedList<Node>();
	

	
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        int numberOfNodes = in.nextInt();
        int numberOfEdges = in.nextInt();
        int nodeA, nodeB;
        
        buildTree(numberOfNodes, numberOfEdges);
        
        
        for(int edge = 0; edge < numberOfEdges; edge++){
        	
        	
        	nodeA = in.nextInt();
        	nodeB = in.nextInt();
        	
        	addEdge(nodeA, nodeB);
        	
            
        }
        
        in.close();
        
        
        getSolution();
        
        printSolution(bestSolution);
        
        
        
        
        
    }


	
	private static void getSolution() {

		
		List<Node> solution = new LinkedList<Node>();
		
		
		findWay(tree.getNodes(), solution);
		
		
	}
	
	
	private static void findWay(List<Node> currTree, List<Node> solution) {

		for (Node currentNode : currTree) {
			
			if(!solution.contains(currentNode)){
				
				if(solution.size() == 0 || solution.get(solution.size()-1).getAvailableNodes().contains(currentNode)){
					
					solution.add(currentNode);
					findWay(currentNode.getAvailableNodes(), new LinkedList<Node>(solution));
				}
				
			}else{
				
				if(solution.size()>bestSolution.size()){
					
					bestSolution = solution;
					if(bestSolution.size() == tree.getNodeSize()){
						break;
					}
				}
				
			}
			
		}
		
	}



	private static void printSolution(List<Node> solution) {
		
		System.out.println(solution.size());
		
		for (Node node : solution) {
			
			System.out.print(node.getIndex());
			
			if(solution.indexOf(node) != solution.size()-1){
				
				System.out.print(" ");
			}
			
		}
		
	}
	



	private static void addEdge(int nodeAIndex, int nodeBIndex) {

		
		Node nodeB = tree.getNode(nodeBIndex);
		Node nodeA = tree.getNode(nodeAIndex);

		nodeA.addEdge(nodeB);
		nodeB.addEdge(nodeA);
		
		
	}



	private static void buildTree(int numberOfNodes, int numberOfEdges) {

		tree = new Tree(numberOfNodes, numberOfEdges);
		
		for (int i = 1; i <= numberOfNodes; i++) {

			tree.addNode(new Node(i));
			
		}
		
	}
}

class Tree{
	
	private int nodeSize;
	private int edgeSize;
	private List<Node> nodes;
	
	public Tree(int nodeSize, int numberOfEdges) {
		
		this.nodeSize = nodeSize;
		this.edgeSize = numberOfEdges;
		nodes = new LinkedList<Node>();
	
	}
	
	public void addNode(Node node){
		
		nodes.add(node);
	}

	public int getNodeSize() {
		return nodeSize;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public int getEdgeSize() {
		return edgeSize;
	}
	
	public List<Node> getNextNodes(Node fromNode){
		
		return nodes.get(nodes.indexOf(fromNode)).getAvailableNodes();
		
	}
	
	public Node getNode(int index){
		
		return nodes.get(nodes.indexOf(new Node(index)));
		
	}

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer("Tree [nodeSize=" + nodeSize + "]\n");
		
		for (Node node : nodes) {
			
			buffer.append(node.toString() + "\n");
			
		} 
		
		return buffer.toString();
	}
	
	
}


class Node {

	private int index;
	private List<Node> availableNodes;
	
	public Node(int index) {
		
		this.index = index;
		availableNodes = new LinkedList<Node>();
	}

	public int getIndex() {
		return index;
	}
	
	public void addEdge(Node nextNode){
		
		availableNodes.add(nextNode);
		
	}
	
	public List<Node> getAvailableNodes(){
		return availableNodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
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
		Node other = (Node) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer("Node [index=" + index + "]");
		
		for (Node node : availableNodes) {
			
			buffer.append(node.getIndex() + " ");
			
		}
		
		return buffer.toString();
	}
	
}

