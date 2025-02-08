import java.util.*;

public class LinkedHashMap_Operation {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        //add the value in linkedlist
        lhm.put("India", 80);
        lhm.put("pakistan", 78);
        lhm.put("Americ", 59);
        lhm.put("nepal", 39);
        lhm.put("Nenital", 68);
        System.out.println(lhm);


        //change the value in linkedlist
        int population = lhm.get("pakistan");
        System.out.println(population);

        //we have use containskey for  check true or false

        System.out.println(lhm.containsKey("Americ"));
        System.out.println(lhm.containsKey("Delhi"));

        System.out.println(lhm.remove("Nenital"));
        System.out.println(lhm);

        System.out.println(lhm.size());





    

    }
}
