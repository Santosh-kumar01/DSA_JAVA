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

        if (ways[n] != -1) { // already calculated
            return ways[n];
        }
        ways[n] = countways(n - 1, ways) + countways(n - 2, ways);
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5; // n=3 -> 3 & n=4 -> 5 =>8
        int ways[] = new int[n + 1]; // memonization
        Arrays.fill(ways, -1);

        System.out.println(countways(n, ways));

    }

}
