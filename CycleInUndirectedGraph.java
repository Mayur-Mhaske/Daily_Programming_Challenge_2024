import java.util.ArrayList;
import java.util.List;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges to the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Undirected graph
        }

        boolean hasCycle = detectCycle(graph, V);
        System.out.println("Does the graph contain a cycle? " + hasCycle); // Output: true
    }

    public static boolean detectCycle(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];

        // Check for cycles in each component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, -1)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle found
    }

    private static boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            // If the neighbor hasn't been visited, continue the DFS
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, node)) {
                    return true; // Cycle found in the recursion
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, a cycle exists
                return true;
            }
        }

        return false; // No cycle found in this path
    }
}
