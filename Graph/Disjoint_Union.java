import java.util.*;

public class Disjoint_Union {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void Disjoint_Union(int a, int b) {
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

   // path compression
    public static void main(String[] args) {
        init();
        Disjoint_Union(1, 3);
        System.out.println(find(3));
        Disjoint_Union(2, 4);
        Disjoint_Union(3, 6);
        Disjoint_Union(1, 4);

        System.out.println(find(3));
        System.out.println(find(4));
        Disjoint_Union(1, 5);

    }

}
