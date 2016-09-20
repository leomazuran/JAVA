// Leonardo Mazuran 
//cs3200 Lab 3 Summer16 
//7-25-16 23:46
import java.util.*;

public class AdjacencyMatrixGraph{
	private boolean isDirected;
	private double[][] adjacencyMatrix;

	//initialize the graph based on a user given adjacency matrix
	public AdjacencyMatrixGraph(double[][] adjMatrix, boolean directed)
	{
		isDirected = directed;
		adjacencyMatrix = new double [adjMatrix.length] [adjMatrix.length];
		for (int u = 0; u < adjMatrix.length; u ++){
			for (int v = 0; v < adjMatrix[u].length; v++){
		
adjacencyMatrix[u][v] = adjMatrix[u][v];
		}}
		
	}

	//get the number of vertices
	public int numVertices() {
		return adjacencyMatrix.length;
	
	}

	//get the number of edges
	public int numEdges() {
		
		// isdirected need to make another for indirect
		//not direct numedges/2
		
		 int sum = 0;
	        for(int i = 0; i < adjacencyMatrix.length ; i++) {
	            for(int j = 0; j < adjacencyMatrix[i].length; j++) {
	                if(adjacencyMatrix[i][j] != 0)
	                    sum++;
	            }
	        }
	        if ( isDirected == true){
	       // return sum;
	        System.out.println("numEdges = Directed");
	        return sum;
	        }
	        else{ 
	        	System.out.println("numEdges = Undirected");
	        	return sum/2;
		
	        }
	}

	//get the number of out degree for the vertex whose index is v
	public int outDegree(int v){
		int sum =0;
		for ( int i = 0; i < adjacencyMatrix[v].length ; i++)
			if (adjacencyMatrix[v][i] > 0){
				sum++;
			}
		return sum;
	}

	//get the number of in degree for the vertex whose index is v
	public int inDegree(int v){
		int sum = 0;
		for ( int i = 0; i < adjacencyMatrix[v].length; i++)
			if (adjacencyMatrix[i] [v] > 0)
				sum++;
		return sum;
		
	}

	//get the list of neighbor for the vertex whose index is v
	public ArrayList<Integer> neighbors(int v){
	
		ArrayList<Integer> n = new ArrayList<Integer>();
		for (int i = 0; i < adjacencyMatrix[v].length ; i++) {
			
	
			if ( adjacencyMatrix[v] [i] != 0)
				n.add(i);
			}
		
		return n;
		
	}
	
	//return true if vertex u and v are neighbors
	public boolean isNeighbors(int u, int v){
		
		if (adjacencyMatrix [u][v] != 0)
			return true;
			else
				return false;
		
		}
		
	
	
	//insert an edge between two vertices, return false if there is an edge between them already
	public boolean insertEdge(int u, int v, double weight){
		
		if (adjacencyMatrix[u][v] !=0)
			return false;
		else
			if(isDirected == false){
		adjacencyMatrix[u][v] = weight;
			}
		if (isDirected == true){
		
		adjacencyMatrix[v][u]= weight;
		}
		return true;
	
		

	}

	//remove an edge between two vertices, return false if there is no edge between them
	public boolean removeEdge(int u, int v){
	if ( adjacencyMatrix [u][v]> 0){
		adjacencyMatrix[u][v]= 0;
		if ( isDirected == true)
		
		adjacencyMatrix[v][u]= 0;
		return true;
	}
	else
		return false;

	}
	
	//get the traversal sequence of the graph by using BFS and keep the sequence in an ArrayList
	public ArrayList<Integer> BFS(int start)
	{
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		LinkedList<Integer> q = new LinkedList <Integer>();
		boolean[] v = new boolean [numVertices()];
	
		q.add(start);
		v [start] = true;
		while (!q.isEmpty()){
			int c = q.remove();
			s.add(c);
			for (int i: neighbors(c)){
				if(v[i] == false){
					q.add(i);	
					v[i] = true;
					
				}
					
			}
		}
		return s;
		    
		         }
	// ArrayList<Integer> = new BFS ArrayList<Integer>
		
	
		
		
	// or DFS()
	 /* get the traversal sequence of the graph by using DFS and keep the sequence in an ArrayList
	 
	public ArrayList<Integer> DFS()
	{

	}*/
	
	
	//print out the adjacency matrix if the number of vertices in the graph is less than 20
	public void printAdjMatrix()
	{
		if ( adjacencyMatrix.length < 20){
		for (int i= 0 ; i < adjacencyMatrix.length; i ++ ){
			for (int j = 0; j < adjacencyMatrix.length; j++){
				System.out.print(adjacencyMatrix[i][j]+ "\t");
				//System.out.println(" ");
			}
			System.out.println(" ");
		}
		
		}else{
			System.out.println("AdjM no output print");
		}
	}
	// true false false false use 3 three removing edge = false
}
