import java.util.*;

public class LinkedHashSetList {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

    lhs.add("Delhi");
    lhs.add("Noida");
    lhs.add("Kolkata");
    lhs.add("Bengluru");
    lhs.add("Karnatka");
    lhs.add("Dhanbad");

    
    lhs.remove("Noida");
    System.out.println(lhs);
    
        
    }
    

    
}
