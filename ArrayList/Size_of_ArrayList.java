package ArrayList;
import java.util.*;

public class Size_of_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.size());

        //print the arrayslist
        for(int i=0; i<list.size(); i++){
            System.out.print( list.get(i) + " ");
        }
        System.out.println(  ) ;

    }

    
}
