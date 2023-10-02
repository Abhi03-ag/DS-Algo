import java.util.*;
import java.lang.*;
import java.io.*;

class Edge {
	public int src, dest, wt;
	Edge(int src, int dest, int wt) {
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}
	public int getWt() {
		return wt;
	}
	public int getSrc() {
		return src;
	}
	public int getDest() {
		return dest;
	}
	@Override
	public String toString() {
		return src + " " + dest + " " + wt;
	}


}
public class Krushkals {
	int V, E;
	Edge[] edgeList;
	Krushkals(int v, int e) {
		this.V = v;
		this.E = e;
		edgeList = new Edge[E];
	}
	public int find(int[] parent, int node) {
		//System.out.println(Arrays.toString(parent) + " " + node);
		if (parent[node] == -1)
			return node;
		int absParent = find(parent, parent[node]);
		parent[node] = absParent;
		return absParent;
	}
	public void union(int[] rank, int[] parent, int node1, int node2) {
		int parent1 = find(parent, node1);
		int parent2 = find(parent, node2);
		if (rank[parent1] > rank[parent2]) {
			parent[parent2] = parent1;
		} else if (rank[parent1] < rank[parent2]) {
			parent[parent1] = parent2;
		}  else {
			parent[parent2] = parent1;
			rank[parent1]++;
		}

	}

	public void findMST() {
		Arrays.sort(edgeList, (e1, e2)->Integer.compare(e1.wt, e2.wt));
		int[] parent = new int[V];
		int[] rank = new int[V];
		Arrays.fill(rank, 0);
		Arrays.fill(parent, -1);
		int edgeListIndex = 0;
		int noOfEdgesCovered = 0;
		ArrayList<Edge> result = new ArrayList<Edge>();
		while (noOfEdgesCovered < V && edgeListIndex < E) {
			Edge e = edgeList[edgeListIndex];
			int parent1 = find(parent, e.src);
			int parent2 = find(parent, e.dest);
			if (parent1 == parent2) {
				//We cannot add this edge because it will lead to cycle
				edgeListIndex++;
				continue;
			}
			union(rank, parent, e.src, e.dest);
			//System.out.println(Arrays.toString(rank) + "," + Arrays.toString(parent) + "," + e.src + "," + e.dest);
			result.add(e);
			noOfEdgesCovered++;
			edgeListIndex++;

		}
		//System.out.println(result);
		if (noOfEdgesCovered == V - 1) {
			System.out.println(result);
		} else {
			System.out.println("There is no possible MST");
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
		Krushkals obj = new Krushkals(noOfVertices, noOfEdges);
		for (int i = 0; i < noOfEdges; i++) {
			int wt = sc.nextInt();
			int src = sc.nextInt();
			int dest = sc.nextInt();
			obj.edgeList[i] = new Edge(src, dest, wt);
		}

		obj.findMST();


	}
}