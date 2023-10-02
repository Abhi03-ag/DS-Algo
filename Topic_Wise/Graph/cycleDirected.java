import java.util.*;
import java.lang.*;
import java.io.*;

public class cycleDirected {
	private final int V;
	private final List<List<Integer>> adj;
	enum State {
		WHITE,
		GREY,
		BLACK;
	}

	public cycleDirected(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);

	}

	public boolean isCyclic() {
		boolean isVisited[] = new boolean [V];
		State state[] = new State[V];
		for (int i = 0; i < V; i++) {
			state[i] = State.WHITE;
		}
		for (int node = 0; node < V; node++) {
			if (!isVisited[node] && detectDfsCycle(node, isVisited, state)) {
				return true;
			}
		}
		return false;
	}
	public boolean detectDfsCycle(int node, boolean[] isVisited, State[] state) {
		System.out.println("Current Node" + node);
		isVisited[node] = true;
		state[node] = State.GREY;

		List<Integer> adjNodeList = adj.get(node);
		for (int adjNode : adjNodeList) {
			System.out.println("Adjacent Node" + adjNode);
			//If the node is not visited and may be its descedents contains cycle we returns true
			if (!isVisited[adjNode] && detectDfsCycle(adjNode, isVisited, state)) {
				System.out.println("Descendents having the issue" + node);
				return true;
			} else if (state[adjNode] == State.GREY) {
				System.out.println("Node with the back edge" + node);
				return true;
			}
		}
		state[node] = State.BLACK;

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

		cycleDirected graph = new cycleDirected(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		//graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains the cycle");
		else
			System.out.println("Graph do not have any cycle");

	}
}