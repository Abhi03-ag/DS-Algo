import java.util.*;
import java.lang.*;
import java.io.*;

//Kosaraju Algorithm for finding the strongly connected componenet in the graph
//Time Complexity: O(V+E) - As we will be traversing the graph twice using the DFS Algorithm
//Space Complexity: O(V) - The no of vertices in the graph

class KosarajuSCC {
	private int V;
	private LinkedList<Integer>[] adjList = null;

	KosarajuSCC(int V) {
		this.V = V;
		adjList = new LinkedList[this.V];
		for (int i = 0; i < V; i++) {
			adjList[i] =  new LinkedList<Integer>();
		}
	}
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	public void printSCC(boolean[] visited, Deque<Integer> stack) {
		int i = 0;
		while (!stack.isEmpty()) {
			int src = stack.pop();
			//System.out.println("The src vertex is" + src);
			if (!visited[src]) {
				System.out.print("The component " + i++ +" is: ");
				dfs(src, visited);
				System.out.println();
			}
		}
	}
	public void findSCC() {
		boolean[] visited = new boolean[V];
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				fillOrder(i, visited, stack);
		}


		Arrays.fill(visited, false);
		KosarajuSCC newGraph = getTransposeGraph();
		newGraph.printSCC(visited, stack);
	}

	public KosarajuSCC getTransposeGraph() {
		KosarajuSCC newGraph = new KosarajuSCC(V);
		for (int i = 0; i < V; i++) {
			for (int adjNode : adjList[i]) {
				newGraph.adjList[adjNode].addLast(i);
			}
		}
		System.out.println(Arrays.toString(newGraph.adjList));
		return newGraph;
	}

	public void dfs(int source, boolean[] visited) {
		visited[source] = true;
		System.out.print(source + " ");
		for (int adjNode : adjList[source]) {
			if (!visited[adjNode])
				dfs(adjNode, visited);
		}
		//stack.push(source);
	}

	public void fillOrder(int source, boolean[] visited, Deque<Integer> stack) {
		visited[source] = true;
		//System.out.print(source+" ");
		for (int adjNode : adjList[source]) {
			if (!visited[adjNode])
				fillOrder(adjNode, visited, stack);
		}
		stack.push(source);
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int noOfVertices = sc.nextInt();
		int noOfEdges = sc.nextInt();
		KosarajuSCC graph = new KosarajuSCC(noOfVertices);
		for (int i = 0; i < noOfEdges; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		graph.findSCC();
	}
}