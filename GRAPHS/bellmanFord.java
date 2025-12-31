import java.util.*;

public class bellmanFord {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Function to create the graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1)); // Negative cycle possibility
    }

    // Bellman-Ford Algorithm
    public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];

        // Step 1: Initialize distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : graph[u]) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[e.dest]) {
                        dist[e.dest] = dist[u] + e.wt;
                    }
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        boolean hasNegativeCycle = false;
        for (int u = 0; u < V; u++) {
            for (Edge e : graph[u]) {
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[e.dest]) {
                    hasNegativeCycle = true;
                    break;
                }
            }
        }

        // Print result
        if (hasNegativeCycle) {
            System.out.println("Graph contains a negative weight cycle!");
        } else {
            for (int i = 0; i < V; i++) {
                System.out.println("Shortest distance from " + src + " to " + i + " = " + dist[i]);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 0;
        bellmanFordAlgo(graph, src);
    }
}
