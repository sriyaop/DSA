import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class Graph {

    // Add an undirected edge
    public static void addEdge(List<List<Edge>> graph, int src, int dest, int weight) {
        graph.get(src).add(new Edge(src, dest, weight));
        graph.get(dest).add(new Edge(dest, src, weight));
    }

    // BFS utility (from a single node)
    public static void bfsUtil(List<List<Edge>> graph, int start, boolean[] visited) {
        List<Integer> queue = new ArrayList<>();
        visited[start] = true;
        queue.add(start);

        for (int index = 0; index < queue.size(); index++) {
            int current = queue.get(index);
            System.out.print(current + " ");

            List<Edge> edges = graph.get(current);
            for (int i = 0; i < edges.size(); i++) {
                int neighbor = edges.get(i).dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // BFS for all connected components
    public static void bfsAll(List<List<Edge>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        System.out.println("BFS for all connected components:");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.print("Component: ");
                bfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    // DFS utility (from a single node)
    public static void dfsUtil(List<List<Edge>> graph, int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        List<Edge> edges = graph.get(current);
        for (int i = 0; i < edges.size(); i++) {
            int neighbor = edges.get(i).dest;
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited);
            }
        }
    }

    // DFS for all connected components
    public static void dfsAll(List<List<Edge>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        System.out.println("DFS for all connected components:");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.print("Component: ");
                dfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    // Check if path exists from src to dest using DFS
    public static boolean hasPath(List<List<Edge>> graph, int src, int dest, boolean[] visited) {
        if (src == dest) return true;

        visited[src] = true;

        List<Edge> edges = graph.get(src);
        for (int i = 0; i < edges.size(); i++) {
            int neighbor = edges.get(i).dest;
            if (!visited[neighbor] && hasPath(graph, neighbor, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    // Print neighbors of a node
    public static void printNeighbors(List<List<Edge>> graph, int node) {
        System.out.println("Neighbors of node " + node + ":");

        List<Edge> edges = graph.get(node);
        for (int i = 0; i < edges.size(); i++) {
            int neighbor = edges.get(i).dest;
            int weight = edges.get(i).weight;
            System.out.println("To " + neighbor + " with weight " + weight);
        }
    }

    public static void main(String[] args) {
        int V = 8;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges for component 1
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 5);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 2, 4, 3);

        // Add edges for component 2
        addEdge(graph, 5, 6, 2);
        addEdge(graph, 6, 7, 4);

        // BFS all components
        bfsAll(graph);

        // DFS all components
        dfsAll(graph);

        // Print neighbors
        printNeighbors(graph, 1);

        // Check path
        int source = 0, destination = 4;
        boolean[] visitedPath = new boolean[V];
        boolean exists = hasPath(graph, source, destination, visitedPath);
        System.out.println("Path from " + source + " to " + destination + ": " + exists);
    }
}
