import java.util.*;

public class Tarjans_Algoritham {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));  // Fixed edge addition
        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 3));  // Corrected to maintain undirected graph property
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int[] time, boolean vis[], boolean AP[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time[0];
        int children = 0;

        for (Edge e : graph[curr]) {
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } 
            if (vis[neigh]) {  // Back edge case
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {  // Forward edge case
                dfs(graph, neigh, curr, dt, low, time, vis, AP);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (par != -1 && dt[curr] <= low[neigh]) {
                   AP[curr] = true;
                }
                children++;
            }
        }

        if (par == -1 && children > 1) {
            AP[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int v) {
        int dt[] = new int[v]; // Discovery time array
        int low[] = new int[v]; // Lowest discovery time reachable
        boolean vis[] = new boolean[v];
        boolean AP[] = new boolean[v]; // Fixed: Declare articulation points array
        int time[] = {0}; // Time tracker as an array to maintain reference

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis, AP);
            }
        }

        // Print articulation points
        for (int i = 0; i < v; i++) {
            if (AP[i]) {
                System.out.println("AP: " + i);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);
    }
}