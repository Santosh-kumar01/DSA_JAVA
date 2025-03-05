import java.util.*;

public class Queries_on_ST {
    static int tree[];

    // Initialize Segment Tree
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build Segment Tree
    public static int buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2; 
        int left = buildST(arr, 2 * i + 1, start, mid);
        int right = buildST(arr, 2 * i + 2, mid + 1, end);
        tree[i] = left + right;
        return tree[i];
    }

    // Utility function to get sum in range
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // Completely outside the range
        if (qj < si || qi > sj) {
            return 0;
        }
        // Completely inside the range
        if (si >= qi && sj <= qj) {
            return tree[i];
        }
        // Partially in and out of the range
        int mid = (si + sj) / 2;
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
        return left + right;
    } 

    // Get sum in a range
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n - 1);

        // Print Segment Tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Print sum in range
        int sum = getSum(arr, 2, 5);
        System.out.println("Sum of elements in range [2, 5]: " + sum);
    }
}