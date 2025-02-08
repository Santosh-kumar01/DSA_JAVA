import java.util.*;

public class Weakest_Soldier {
    static class Row implements Comparable<Row> {
        int weakestSoldiers;
        int index;

        public Row(int soldiers, int index) {
            this.weakestSoldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.weakestSoldiers == r2.weakestSoldiers) {
                return this.index - r2.index;
            } else {
                return this.weakestSoldiers - r2.weakestSoldiers;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 0, 0, 0, 0}
        };

        int k = 2; // Number of weakest rows to find
        PriorityQueue<Row> pq = new PriorityQueue<>();
        
        // Calculate soldier count for each row
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                } else {
                    break; // Stop counting if a zero is encountered
                }
            }
            pq.add(new Row(count, i));
        }

        // Retrieve and print the weakest rows
        System.out.println("The " + k + " weakest rows are:");
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            System.out.println("Row " + pq.remove().index);
        }
    }
}
