import java.util.*;

public class Maximum_of_all_subarrays_of_size_k {
    static void printMax(int arr[], int n, int k) {
        Deque<Integer> Qi = new LinkedList<Integer>();
        int i;

        // Process the first k elements
        for (i = 0; i < k; ++i) {
            // For every element, remove the smaller elements from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add new element at the rear of Qi
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the deque is the largest element of previous subarray
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while (!Qi.isEmpty() && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently being added element (arr[i])
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum of the last window
        System.out.print(arr[Qi.peek()]);
    }

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
