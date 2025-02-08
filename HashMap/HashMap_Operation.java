import java.util.HashMap;

public class HashMap_Operation {
    public static void main(String[] args) {
        //create a HashMap - 0(1)
        HashMap<String, Integer> hm = new HashMap<>();
        //Create operations
        hm.put("Santosh", 29);
        hm.put("Ravi", 67);
        hm.put("Prince", 12);
        hm.put("sahil", 89);
        System.out.println(hm);

        //get a HashMap - o(1)

        int population = hm.get ("Santosh");
        System.out.println(population); 

        //if not in create in hashmap in list 
        System.out.println(hm.get("Yash"));

        // conatainsKey - o(1) // we have use exits ot not mains true or false
        System.out.println(hm.containsKey("Ravi"));
        System.out.println(hm.containsKey("Vishal"));

         // remove - 0(1)
         
         System.out.println(hm.remove("sahil"));
         System.out.println(hm);


        //if we know size 
        System.out.println(hm.size());
        

        //IS Empty
        //hm.clear();    // all data are clear
        System.out.println(hm.isEmpty());




        
    }

}
