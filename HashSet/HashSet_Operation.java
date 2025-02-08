import java.util.*;

public class HashSet_Operation {
    public static void main(String[] args) {
        HashSet<Integer> Set = new HashSet<>();
        //ADDING OPERATION
        Set.add(1);
        Set.add(4);
        Set.add(7);
        Set.add(1);
        Set.add(6);
        Set.add(7);
        System.out.println(Set);

        

        //delete 
        // Set.remove(4);

        //exist or not 
        if(Set.contains(4)){
            System.out.println("Set contains 4");
        }
        if(Set.contains(0)){
            System.out.println("Set contain 0");
        }
        Set.remove(6);
         //for size
        System.out.println(Set.size());

        // data clear
        Set.clear();

        //if data not present then true otherwise false
        System.out.println(Set.isEmpty());
    }

    
    
}
