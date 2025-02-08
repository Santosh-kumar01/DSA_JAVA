import java.util.*;

public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
public class Flood_Fill_Algorithm {
        // Boundary conditions and constraints
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // Mark the pixel as visited and change its color
        vis[sr][sc] = true;
        image[sr][sc] = color;

        // Move in all four directions
        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Avoid unnecessary processing if the new color matches the original color
        if (image[sr][sc] == color) {
            return image;
        }

        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        Flood_Fill_Algorithm floodFill = new Flood_Fill_Algorithm();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        System.out.println("Original Image:");
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }

        int[][] result = floodFill.floodFill(image, sr, sc, color);

        System.out.println("\nImage after Flood Fill:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}