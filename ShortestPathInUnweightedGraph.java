import java.util.*;

public class ShortestPathInUnweightedGraph {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        int start = 0; // Starting node
        int end = 4;   // Ending node

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

        int shortestPathLength = bfsShortestPath(graph, start, end);
        System.out.println("Shortest path length from " + start + " to " + end + " is: " + shortestPathLength);
    }

    public static int bfsShortestPath(List<List<Integer>> graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        int[] distance = new int[graph.size()];

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Check if we've reached the end node
            if (node == end) {
                return distance[node];
            }

            // Explore neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1; // Increment the distance
                    queue.offer(neighbor);
                }
            }
        }

        return -1; // Return -1 if no path found
    }
}
