

import java.util.Comparator;
import java.util.PriorityQueue;


public class java_collection_framwork {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());// comparator.reverseOrder is used to reverse the elements.
        pq.add(3); // o(logn) // n is the number in thisalready our under priority queue exits respectively.
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());   //o(1)
            pq.remove();  //o(logn)
            
        }
       
    }
    
}




// import java.util.Comparator;
// import java.util.PriorityQueue;


// public class java_collection_framwork {
//     public static void main(String[] args) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         pq.add(3); // o(logn) // n is the number in thisalready our under priority queue exits respectively.
//         pq.add(4);
//         pq.add(1);
//         pq.add(7);
//         while (!pq.isEmpty()) {
//             System.out.println(pq.peek());   //o(1)
//             pq.remove();  //o(logn)
            
//         }
       
//     }
    
// }
