// package ArrayList;

import java.util.ArrayList;
// import java.util.stream.Gatherer.Integrator;

public class Swap_two_Number {
    public static void swaps(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

    } 

    //Swaps two numbers
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int idx1 = 1, idx2 = 3;
        System.out.println(list);
        swaps(list, idx1, idx2);
        System.out.println(list);
    }
    
}
