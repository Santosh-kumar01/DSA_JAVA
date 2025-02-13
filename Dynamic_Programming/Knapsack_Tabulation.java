import java.util.*;

public class Knapsack_Tabulation {

    // Memoization approach (Top-Down)
    public static int knapsack(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) { // valid case
            // Include item
            int ans1 = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1, dp);
            // Exclude item
            int ans2 = knapsack(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
        } else { // Not valid
            dp[n][w] = knapsack(val, wt, w, n - 1, dp);
        }
        return dp[n][w];
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tabulation approach (Bottom-Up)
    public static int Knapsack_Tabulation(int val[], int wt[], int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        // Filling DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                int value = val[i - 1]; // Value of current item
                int weight = wt[i - 1]; // Weight of current item

                if (weight <= j) {
                    int incProfit = value + dp[i - 1][j - weight]; // Include item
                    int excProfit = dp[i - 1][j]; // Exclude item
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    dp[i][j] = dp[i - 1][j]; // Exclude item
                }
            }
        }
        print(dp);
        return dp[n][w];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int w = 7;
        int n = val.length;

        // Memoization (Top-Down)
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Memoization (Top-Down) Result: " + knapsack(val, wt, w, n, dp));

        // Tabulation (Bottom-Up)
        System.out.println("Tabulation (Bottom-Up) Result: " + Knapsack_Tabulation(val, wt, w));
    }
}
