import java.util.*;

public class CycleDirected {

    // Edge class representing a directed edge from src to dest
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Main function to detect cycle in the directed graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];   // visited array
        boolean[] stack = new boolean[graph.length]; // recursion stack

        // Check each vertex (to handle disconnected components)
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // If cycle is found starting from this node
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false; // No cycle found
    }

    // Utility function for DFS traversal with cycle detection
    private static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;   // mark current node as visited
        stack[curr] = true; // add to recursion stack

        // Traverse all neighbours
        for (int i=0;i<graph[curr].size();i++) {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]) {
                // Recurse if not visited
                if (isCycleUtil(graph, e.dest, vis, stack)) {
                    return true;
                }
            } else if (stack[e.dest]) {
                // If neighbour is in recursion stack, cycle detected
                return true;
            }
        }

        stack[curr] = false; // remove from recursion stack before backtracking
        return false;
    }

    // Helper method to create the graph with sample edges
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Sample directed graph with a cycle: 0 → 1 → 2 → 0
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
    }

    // Driver code
    public static void main(String[] args) {
        int V = 3; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph); // build the graph

        if (isCycle(graph)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle in the graph.");
        }
    }
}
