package Queue;
import java.util.*;
public class Queue_using_JCF {  // JCF:- Jva class framwork
    //Time complexity of JCF is o(1).
    
    public static void main(String args[]) {
        // Queue q = new Queue();
       // Queue<Integer> q = new LinkedList<>();
       Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();

        }
    }
}
