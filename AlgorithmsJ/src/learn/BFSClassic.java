package algo;
import java.io.IOException;
import java.util.*;

public class BFSClassic {
	
	public static void main(String[] args) {
		char[][] matrix= {{'s','x','o','o','o','o'},
						  {'o','o','o','x','x','o'},
						  {'o','o','o','x','x','o'},
						  {'o','o','o','x','x','o'},
						  {'o','o','o','o','x','o'},
						  {'o','x','x','o','o','o'},
						  {'x','x','o','o','o','e'}};
		traverse(matrix);
	}
	
	static class Node{
		int x;
		int y;
		int distance;
		
		public Node(int x,int y, int distance) {
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}
		
	}
	
	public static void traverse(char[][] matrix) {
		Set<Node> visitedNodes = new HashSet<>();
		Queue<Node> q= new LinkedList<>();
		Node root= new Node(0,0,0);
		visitedNodes.add(root);
		q.add(root);
		_traverse(matrix,q,visitedNodes);
	}
	
	public static void _traverse(char[][] matrix, Queue<Node> q,Set<Node> visitedNodes) {
		int m=matrix.length;
		int n=matrix[0].length;
		Node parent = q.poll();
		if(matrix[parent.x][parent.y]=='e') {
			System.out.println("End reached!");
			return;
		}
		else if(matrix[parent.x][parent.y]!='s'){
			matrix[parent.x][parent.y]='*';	
		}
		print(matrix);
		System.out.println("visiting node : "+parent);
		
		visitedNodes.add(parent);
		
		int rightChildX=parent.x;
		int rightChildY=parent.y+1;
		int downChildX=parent.x+1;
		int downChildY=parent.y;
		
		Node rightChild = new Node(rightChildX,rightChildY,parent.distance+1);
		Node downChild = new Node(downChildX,downChildY,parent.distance+1);
		
		if(rightChild.x<m && rightChild.y<n && !visitedNodes.contains(rightChild) && matrix[rightChildX][rightChildY]!='x') {
			q.add(rightChild);
		}
		if(downChild.x<m && downChild.y<n && !visitedNodes.contains(downChild) && matrix[downChildX][downChildY]!='x') {
			q.add(downChild);
		}
		_traverse(matrix,q,visitedNodes);
	}
	
	public static void cls(){
	    try {

	     if (System.getProperty("os.name").contains("Windows"))
	         new ProcessBuilder("cmd", "/c", 
	                  "cls").inheritIO().start().waitFor();
	     else
	         Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	
	public static void print(char[][] matrix) {
		try {
			cls();
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		for(char[] ch:matrix) {
			for(char c: ch) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
