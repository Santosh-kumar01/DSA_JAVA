import java.util.*;

public class HashSet_using_Iterator {
    public static void main(String[] args) {
        HashSet<String> Cities = new HashSet<>();
        Cities.add("Delhi");
        Cities.add("Mumbai");
        Cities.add("Noida");
        Cities.add("bangluru");

        // Iterator itr = Cities.iterator();
        // while(itr.hasNext()) {
        //     System.out.println(itr.next());

            
        // }

        //Advance for loop used
        for(String city : Cities){
            System.out.println(city);
        }


    }
    
}
