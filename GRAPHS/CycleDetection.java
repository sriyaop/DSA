import java.util.*;

public class CycleDetection {

    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Add undirected edge
    static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    // Create undirected graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 3, 4);
    }

    // -------------------- DFS Cycle Detection --------------------
    public static boolean detectCycleDFS(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (dfsUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (Edge e : graph[current]) {
            int neighbor = e.dest;
            if (!visited[neighbor]) {
                if (dfsUtil(graph, visited, neighbor, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }

        return false;
    }

    // -------------------- BFS Cycle Detection --------------------
    public static boolean detectCycleBFS(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (bfsUtil(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfsUtil(ArrayList<Edge>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            for (Edge e : graph[current]) {
                int neighbor = e.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                } else if (parent[current] != neighbor) {
                    return true; // Cycle detected
                }
            }
        }

        return false;
    }

    // -------------------- Bipartite Check using BFS --------------------
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0; // Start with color 0

                while (!queue.isEmpty()) {
                    int curr = queue.remove();

                    for (Edge e : graph[curr]) {
                        int neighbor = e.dest;
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[curr];
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[curr]) {
                            return false; // Same color found -> Not bipartite
                        }
                    }
                }
            }
        }

        return true;
    }

    // -------------------- Main Method --------------------
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean hasCycleDFS = detectCycleDFS(graph);
        System.out.println("Cycle detected using DFS: " + hasCycleDFS);

        boolean hasCycleBFS = detectCycleBFS(graph);
        System.out.println("Cycle detected using BFS: " + hasCycleBFS);

        boolean bipartite = isBiPartite(graph);
        System.out.println("Is graph bipartite: " + bipartite);
    }
}
