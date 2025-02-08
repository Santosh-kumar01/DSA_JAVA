package ArrayList;
import java.util.ArrayList;

//import java.util.*;

public class ArraysList {

    public static void main(String args[]) {
        //Java Collection FrameWork
        //class objectName = new ClassName();˜
        //<>:-angular bracket
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        //ADDING OPERATION

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(100);

        list.add(1, 9);

        System.out.println(list);

        //get opertion

        // int element = list.get(5);
        // System.out.println(element);

        //remove operation 

        // list.remove(3);
        // System.out.println(list);

        //set 
        // list.set(2, 10);
        // System.out.println(list);

        //contains element
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));
    }
    
    

}
