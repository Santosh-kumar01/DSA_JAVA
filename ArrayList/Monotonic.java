import java.util.*;

public class Monotonic {
    public boolean isMonotonic(List<Integer> A) {
        if (A.size() <= 1) return true; // A single-element list is monotonic by definition

        boolean inc = true;
        boolean dec = true;
        
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                inc = false;
            }
            if (A.get(i) < A.get(i + 1)) {
                dec = false;
            }
            // Early return if both are false
            if (!inc && !dec) {
                return false;
            }
        }
        return inc || dec;
    }
    
    public static void main(String[] args) {
        Monotonic mono = new Monotonic();
        List<Integer> list = Arrays.asList(1, 2, 2, 3);
        System.out.println(mono.isMonotonic(list));  // Output: true
    }
}
