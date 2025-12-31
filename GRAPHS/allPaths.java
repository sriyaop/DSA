import java.util.ArrayList;

public class allPaths {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(0, 3));
    }

    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, ArrayList<Integer> path) {
        path.add(src); // Add current node to the path

        if (src == dest) {
            // Reached destination, print the path
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            // Explore all neighbors
            for (Edge e : graph[src]) {
                findAllPaths(graph, e.dest, dest, path);
            }
        }

        path.remove(path.size() - 1); // Backtrack
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 5, dest = 1;
        System.out.println("All paths from " + src + " to " + dest + ":");
        findAllPaths(graph, src, dest, new ArrayList<>());
    }
}
