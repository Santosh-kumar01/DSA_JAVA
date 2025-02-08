import java.util.*;

public class TreeMap_Operation {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("school", 68);
        tm.put("hospital", 268);
        tm.put("Advocate", 628);
        tm.put("Temple", 618);
        tm.put("Library", 1268);
        System.out.println(tm);

        int population = tm.get("hospital"); // change
        System.out.println(population);

        System.out.println(tm.size()); // for size

        System.out.println(tm.remove("Advocate"));
       
    }
    
}
