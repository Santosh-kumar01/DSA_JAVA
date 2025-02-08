import java.util.*;

public class Kruskals_Algorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        // Add edges to the graph
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4; // Number of vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0; // Initialize rank to 0
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]); // Path compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void KruskalsMST(ArrayList<Edge> edges, int V) {
        init(); // Initialize the parent and rank arrays
        Collections.sort(edges); // Sort edges by weight
        int mstWeight = 0;
        int edgeCount = 0;

        for (int i = 0; edgeCount < V - 1; i++) {
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            // If adding this edge doesn't form a cycle
            if (parA != parB) {
                union(e.src, e.dest);
                mstWeight += e.wt;
                edgeCount++;
            }
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges); // Populate the graph
        KruskalsMST(edges, V); // Compute the MST
    }
}