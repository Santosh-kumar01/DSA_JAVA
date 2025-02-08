import java.util.*;
public class Interation_On_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 96);
        hm.put("Indonacia", 98);
        hm.put("china", 8);
        hm.put("Goa", 86);
        

        Set<String> keys = hm.keySet();
        System.out.println(keys);


        //foreach loops
        for(String k : keys){
            System.out.println("keys=" +k+ ", value="+hm.get(k));
        }
    }
    
}

