import java.util.*;
import java.lang.*;
import java.io.*;

public class Prims {
	class Edge {
		int v;
		int wt;
		Edge(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}

	}
	class Node {
		int vertex;
		int key;
	}
	static class Graph {
		int V;
		LinkedList<Edge>[] adjList;

		Graph(int noOfVertices) {
			V = noOfVertices;

			adjList = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new LinkedList<Edge>();
			}
		}
	}
	public void addEdge(Graph g, int src, int dest, int wt) {
		Edge e1 = new Edge(dest, wt);
		Edge e2 = new Edge(src, wt);
		g.adjList[src].addLast(e1);
		g.adjList[dest].addLast(e2);
	}
	public void findMST(Graph g) {
		boolean[] mstSet = new boolean[g.V];
		Node nodeList[] = new Node[g.V];
		int[] parent = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			nodeList[i] = new Node();
		}

		//Intialize all vertices wt to infinity,parent to -1 and mstSet false
		for (int i = 0; i < g.V; i++) {
			mstSet[i] = false;
			nodeList[i].vertex = i;
			nodeList[i].key = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		nodeList[0].key = 0;
		//We are using the TreeSet instead of priorityqueue because in java pq remove operation is o(n) whereas remove operation of treeset is o(logn).
		TreeSet<Node> queue = new TreeSet<Node>((a, b)->Integer.compare(a.key, b.key));
		for (int i = 0; i < g.V; i++) {
			queue.add(nodeList[i]);
		}
		while (!queue.isEmpty()) {
			Node node = queue.pollFirst();

			mstSet[node.vertex] = true;

			for (Edge e1 : g.adjList[node.vertex]) {
				if (mstSet[e1.v] == false) {
					if (nodeList[e1.v].key > e1.wt) {
						queue.remove(nodeList[e1.v]);
						nodeList[e1.v].key = e1.wt;
						queue.add(nodeList[e1.v]);
						parent[e1.v] = node.vertex;
					}
				}
			}
		}

		//Printing the MST
		for (int i = 0; i < g.V; i++) {
			System.out.println(parent[i] + "	-	" + i);
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
		int V = 9;
		Graph graph = new Graph(V);
		Prims p = new Prims();

		p.addEdge(graph, 0, 1, 4);
		p.addEdge(graph, 0, 7, 8);
		p.addEdge(graph, 1, 2, 8);
		p.addEdge(graph, 1, 7, 11);
		p.addEdge(graph, 2, 3, 7);
		p.addEdge(graph, 2, 8, 2);
		p.addEdge(graph, 2, 5, 4);
		p.addEdge(graph, 3, 4, 9);
		p.addEdge(graph, 3, 5, 14);
		p.addEdge(graph, 4, 5, 10);
		p.addEdge(graph, 5, 6, 2);
		p.addEdge(graph, 6, 7, 1);
		p.addEdge(graph, 6, 8, 6);
		p.addEdge(graph, 7, 8, 7);

		// Method invoked
		p.findMST(graph);
	}
}

//Time Complexity - O((V+E)LogV) ~ O(ELogV) (Since for connected graph V =O(E)).
//Space Complexity - O(V).