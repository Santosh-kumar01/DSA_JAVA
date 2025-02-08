
import java.util.*;
public class Insert_in_Heap {
    static class InnerInsert_in_Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){ // o(log n)
            //add at last index
            arr.add(data);
            int x=arr.size()-1;// x is child index
            int par = (x-1)/2;//par index

            while (arr.get(x) < arr.get(x)) {  // o(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                
                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i ){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx =i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //step2 - delete last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            arr.remove(arr.size()-1);

            //step3 - heapfity
            heapify(0);
            return data;

        }
        public boolean isEmpty(){
            return arr.size() == 0;

        }
    
        
    }
    public static void main(String[] args) {
        InnerInsert_in_Heap heap = new InnerInsert_in_Heap();
        heap.add(10);
        heap.add(3);
        heap.add(4);
        heap.add(9);
        heap.add(2);
        heap.add(6);

        while(!heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.remove();
            
        }

        
    }
    
}
