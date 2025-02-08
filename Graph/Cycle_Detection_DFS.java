import java.util.*;

public class Cycle_Detection_DFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // static void createGraph(ArrayList<Edge> graph[]) { // true
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 1));
    //     graph[1].add(new Edge(1, 2));
    //     graph[2].add(new Edge(2, 3));
    //     graph[3].add(new Edge(3, 0)); // Cycle is created here
    // }

    static void createGraph(ArrayList<Edge> graph[]) { // false
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2)); 
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3)); // Cycle is created here
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If the node is already in the recursion stack, a cycle is found
            if (stack[e.dest]) {
                return true;
            }
            // Recur for unvisited neighbors
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false; // Remove from recursion stack
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(isCycle(graph)); // Expected output: true
    }
}