import java.util.*;

public class MCM_Tabulation {

    // Memoization approach (Top-Down DP)
    public static int mcmMemo(int arr[], int i, int j, int[][] dp) {
        if (i == j) return 0; // No multiplication cost for a single matrix

        if (dp[i][j] != -1) {
            return dp[i][j]; // Use previously computed result
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    // Tabulation approach (Bottom-Up DP)
    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // Bottom-up DP
        for (int len = 2; len <= n - 1; len++) { // Chain length
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize with large value

                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        print(dp);
        return dp[1][n - 1];
    }
    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++ ){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};

        // Tabulation approach
        System.out.print("Minimum Cost (Tabulation): " + mcmTab(arr));

        // Memoization approach
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        // System.out.print("Minimum Cost (Memoization): " + mcmMemo(arr, 1, n - 1, dp));
    }
}