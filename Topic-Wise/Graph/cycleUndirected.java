import java.util.*;
import java.lang.*;
import java.io.*;

public class  cycleUndirected {
	private final int V;
	private final List<List<Integer>> adj;


	public cycleUndirected(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);

	}

	public boolean isCyclic() {
		boolean isVisited[] = new boolean [V];
		int parent[] = new int[V];
		Arrays.fill(parent, -1);
		for (int node = 0; node < V; node++) {
			if (!isVisited[node] && detectBfsCycle(node, isVisited, parent)) {
				return true;
			}
		}
		return false;
	}
	public boolean detectBfsCycle(int node, boolean[] isVisited, int[] parent) {
		System.out.println("Current Node" + node);
		isVisited[node] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			List<Integer> adjNodeList = adj.get(currentNode);
			for (int adjNode : adjNodeList) {
				//If the node is not visited and may be its descedents contains cycle we returns true
				System.out.println("Adjacent Node" + adjNode + "of this Node" + currentNode);
				if (!isVisited[adjNode]) {
					//System.out.println("Descendents having the issue" + node);
					queue.offer(adjNode);
					isVisited[adjNode] = true;
					parent[adjNode] = currentNode;
				} else if (isVisited[adjNode] && parent[currentNode] != adjNode) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);

		cycleUndirected graph = new cycleUndirected(3);

		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		// graph.addEdge(2, 1);
		// graph.addEdge(0, 3);
		// graph.addEdge(3, 4);

		if (graph.isCyclic())
			System.out.println("Graph contains the cycle");
		else
			System.out.println("Graph do not have any cycle");

	}
}