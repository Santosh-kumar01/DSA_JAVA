import java.util.Arrays;
// memoization -o(n):- these are well optimized | recursion (2^n):- these are very slow
public class Climbing_Stairs {
    public static int countways(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
<<<<<<< HEAD

        if (ways[n] != -1) { // already calculated
            return ways[n];
        }
        ways[n] = countways(n - 1, ways) + countways(n - 2, ways);
        return ways[n];
    }

    //for tabulation
    //Time complexity:-o(n)
    public static int countwaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        //tabulation loop 
        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // n=3 -> 3 & n=4 -> 5 =>8
=======

        if (ways[n] != -1) { // already calculated
            return ways[n];
        }
        ways[n] = countways(n - 1, ways) + countways(n - 2, ways);
        return ways[n];
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        int n = 5; // n=3 -> 3 & n=4 -> 5 => 8
>>>>>>> 6562fde (Optimize Climbing Stairs implementation using memoization)
=======
        int n = 5; // n=3 -> 3 & n=4 -> 5 =>8
>>>>>>> 3537079 (Fix formatting in Climbing Stairs main method comment)
        int ways[] = new int[n + 1]; // memonization
        Arrays.fill(ways, -1);

        System.out.println(countways(n, ways));
<<<<<<< HEAD
        System.out.println(countwaysTab(n));
=======
>>>>>>> 6562fde (Optimize Climbing Stairs implementation using memoization)

    }

}
