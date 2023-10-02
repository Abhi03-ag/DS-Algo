//Java program to print all topological sorts of a graph
import java.util.*;
import java.io.*;

class AllTopoSortOrder {
    int V; // No. of vertices

    List<Integer> adjListArray[];

    public AllTopoSortOrder(int V) {

        this.V = V;

        @SuppressWarnings("unchecked")
        List<Integer> adjListArray[] = new LinkedList[V];

        this.adjListArray = adjListArray;

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }
    // Utility function to add edge
    public void addEdge(int src, int dest) {

        this.adjListArray[src].add(dest);

    }

    // Main recursive function to print all possible
    // topological sorts
    private void allTopologicalSortsUtil(boolean[] visited,
                                         int[] indegree, ArrayList<Integer> stack) {
        // To indicate whether all topological are found
        // or not
        boolean flag = false;

        for (int i = 0; i < this.V; i++) {
            // If indegree is 0 and not yet visited then
            // only choose that vertex
            System.out.println("Vertex V is" + i);
            if (!visited[i] && indegree[i] == 0) {

                // including in result
                System.out.println("Visited" + i);
                visited[i] = true;
                stack.add(i);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]--;
                }
                allTopologicalSortsUtil(visited, indegree, stack);

                // resetting visited, res and indegree for
                // backtracking
                visited[i] = false;
                System.out.println("UnVisited" + i);
                stack.remove(stack.size() - 1);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]++;
                }

                flag = true;
            }
        }
        // We reach here if all vertices are visited.
        // So we print the solution here
        if (!flag) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }

    }

    // The function does all Topological Sort.
    // It uses recursive alltopologicalSortUtil()
    public void allTopologicalSorts() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[this.V];

        int[] indegree = new int[this.V];

        for (int i = 0; i < this.V; i++) {

            for (int var : this.adjListArray[i]) {
                indegree[var]++;
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();

        allTopologicalSortsUtil(visited, indegree, stack);
    }

    // Driver code
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("../Input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }

        // Create a graph given in the above diagram
        AllTopoSortOrder graph = new AllTopoSortOrder(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);

        System.out.println("All Topological sorts");
        graph.allTopologicalSorts();
    }
}