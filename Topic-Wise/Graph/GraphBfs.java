// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;


class GraphBfs {

	private final int V;
	private final List<List<Integer>> adj;

	public GraphBfs(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	// This function is a variation of DFSUtil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited,
	                             boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		System.out.println("Current Node is" + i);

		if (recStack[i]) {
			System.out.println("Cyclic Node is" + i);
			return true;
		}



		// if (visited[i])
		// 	return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);

		for (Integer c : children)
			if (isCyclicUtil(c, visited, recStack))
				return true;

		recStack[i] = false;

		return false;
	}
	public boolean isDfsCycle(int node, boolean[] visited, int[] parent) {
		visited[node] = true;
		System.out.println("Node:" + node);
		System.out.println(Arrays.toString(parent));
		System.out.println(Arrays.toString(visited));
		for (int adjNode : adj.get(node)) {
			System.out.println("AdjNode:" + adjNode);
			if (!visited[adjNode]) {
				parent[adjNode] = node;
				if (isDfsCycle(adjNode, visited, parent)) {
					System.out.println("Current Node:" + adjNode);
					System.out.println(Arrays.toString(parent));
					System.out.println(Arrays.toString(visited));
					return true;
				}
			} else {
				if (parent[node] != adjNode) {
					System.out.println("Current Node:" + adjNode);
					System.out.println(Arrays.toString(parent));
					System.out.println(Arrays.toString(visited));
					return true;
				}
			}
		}
		return false;

	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}

// Returns true if the graph contains a
// cycle, else false.
// This function is a variation of DFS() in
// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean visited[] = new boolean[V];
		int parent[] = new int[V];
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isDfsCycle(i, visited, parent))
					return true;
			}
		}
		return false;
	}

// Driver code
	public static void main(String[] args) {
		GraphBfs graph = new GraphBfs(4);

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
			                   + "contain cycle");
	}
}

// This code is contributed by Sagar Shah.
