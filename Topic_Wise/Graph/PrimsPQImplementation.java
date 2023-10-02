import java.util.*;
import java.lang.*;
import java.io.*;

final class Node {
	private final int vertex;
	private final int key;
	Node(int v, int k) {
		this.vertex = v;
		this.key = k;
	}
	public int getVertex() {
		return vertex;
	}
	public int getKey() {
		return key;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Node obj = (Node)o;
		return this.vertex == obj.vertex && this.key == obj.key;

	}
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode = hashCode * 31 + this.key;
		hashCode = hashCode * 31 + this.vertex;
		return hashCode;
	}

}
public class PrimsPQImplementation {
	int V;
	LinkedList<int[]>[] adjList;
	PrimsPQImplementation(int noOfVertices) {
		V = noOfVertices;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<int[]>();
		}

	}
	public void addEdge(int src, int dest, int wt) {
		adjList[src].add(new int[] {dest, wt});
		adjList[dest].add(new int[] {src, wt});

	}
	public void findMST() {
		boolean[] mstSet = new boolean[V];
		int[] parent = new int[V];
		int[] key = new int[V];

		for (int i = 0; i < V; i++) {
			mstSet[i] = false;
			parent[i] = -1;
			key[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		TreeSet<Node> queue = new TreeSet<Node>((a, b)->Integer.compare(a.getKey(), b.getKey()));
		for (int i = 0; i < V; i++) {
			queue.add(new Node(i, key[i]));
		}

		for (int i = 0; i < V; i++) {
			Node node = queue.pollFirst();
			System.out.println(node.getVertex() + " " + node.getKey());
			int nodeVertex = node.getVertex();
			mstSet[nodeVertex] = true;

			for (int[] edge : adjList[nodeVertex]) {
				int v = edge[0];
				int wt = edge[1];
				if (mstSet[v] == false && key[v] > wt) {
					queue.remove(new Node(v, key[v]));
					key[v] = wt;
					queue.add(new Node(v, key[v]));	//O(log V) step to reconstruct the heap
					parent[v] = nodeVertex;
				}
			}
		}

		for (int i = 0; i < V; i++) {
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
		int noOfVertices = 9;
		PrimsPQImplementation graph = new PrimsPQImplementation(noOfVertices);


		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);

		graph.findMST();
	}
}