import java.util.*;
class Pair<T, V> {
	private  final T dest;
	private  final V wt;
	Pair(T u, V v) {
		dest = u;
		wt = v;
	}
	public  T getDest() {
		return dest;
	}
	public  V getWeight() {
		return wt;
	}
}
class Graph {
	private static int nodes;
	private static ArrayList<ArrayList<Pair<Integer, Integer>>> adjList;

	Graph(int node) {
		nodes = node;
		adjList = new ArrayList<ArrayList<Pair<Integer, Integer>>>(node + 1);
		for (int i = 0; i <= node; ++i)
			adjList.add(new ArrayList<Pair<Integer, Integer>>());
	}

	public void addEdge(int src, int dest, int wt) {
		adjList.get(src).add(new Pair(dest, wt));
		adjList.get(dest).add(new Pair(src, wt));
	}
	public static void bfs() {
		boolean visited[] = new boolean[nodes + 1];
		Arrays.fill(visited, false);

		for (int i = 1; i <= nodes; i++) {
			if (!visited[i]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				visited[i] = true;
				queue.offer(i);
				while (!queue.isEmpty()) {
					System.out.println(queue.poll());
					for (Pair<Integer, Integer> adjNode : adjList.get(i)) {
						Integer destination = adjNode.getDest();
						if (!visited[destination]) {
							visited[destination] = true;
							queue.add(destination);
						}
					}

				}

			}
		} cc
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph(4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 1, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 4, 1);

		bfs();
	}
}