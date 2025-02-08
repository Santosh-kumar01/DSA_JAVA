import java.util.*;
public class Count_Distinct_Element {
    public static void main(String[] args) {
        int num[] = {2, 6, 4, 8, 2, 3, 6 ,3 ,5 , 8, 1};
        HashSet<Integer> set = new HashSet<>();

        for(int i =0; i<num.length; i++){
            set.add(num[i]);
        }
        System.out.println("ans =" + set.size());
    }
}
