import java.util.*;
import java.lang.*;
import java.io.*;

public class TarjanSCC {
	private int V;
	private LinkedList<Integer>[] adjList;
	int time = 0;
	TarjanSCC(int v) {
		this.V = v;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	public void findSCC() {
		int visited[] = new int[V];
		int[] d = new int[V];
		int[] low = new int[V];
		Deque<Integer> stack = new ArrayDeque<Integer>();


		for (int i = 0; i < V; i++) {
			visited[i] = 0;
			d[i] = -1;
			low[i] = -1;
		}

		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				DFS(i, visited, d, low, stack);
			}
		}


	}

	public void DFS(int source, int[] visited, int[] d, int[] low, Deque<Integer> stack) {
		visited[source] = -1;
		d[source] = low[source] = time++;
		stack.push(source);

		for (int adjNode : adjList[source]) {
			if (visited[adjNode] == 0) {
				DFS(adjNode, visited, d, low, stack);
				low[source] = Math.min(low[source], low[adjNode]);
			} else if (visited[adjNode] == -1) {
				low[source] = Math.min(low[source], d[adjNode]);
			}
		}
		if (d[source] == low[source]) {
			for (int node = stack.pop(); ; node = stack.pop()) {
				visited[node] = 1;
				System.out.print(node);
				if (node == source) {
					System.out.println();
					break;
				}
			}
		}
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
		TarjanSCC graph = new TarjanSCC(noOfVertices);
		for (int i = 0; i < noOfEdges; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		graph.findSCC();
	}
}