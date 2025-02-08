import java.util.*;

public class Hash_Path {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex-0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // vertex-1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // vertex-2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // vertex-3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        // vertex-4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // vertex-5
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));

        // vertex-6
        graph[6].add(new Edge(6, 5));
    }

    public static boolean Has_Path(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true; // Destination reached
        }

        vis[src] = true; // Mark the current node as visited

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest]) { // Explore unvisited neighbors
                if (Has_Path(graph, e.dest, dest, vis)) {
                    return true; // Path found
                }
            }
        }

        return false; // No path found
    }

    public static void main(String[] args) {
        int v = 7; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean vis[] = new boolean[v];
        System.out.println(Has_Path(graph, 0, 5, vis)); // Check if a path exists from 0 to 5
    }
}