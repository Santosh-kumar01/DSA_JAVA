import java.util.*;
public class Reverse_String {
    public static String Reverse_String(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx <str.length()) {
            s.push(str.charAt(idx));
            idx++;
            
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);            
        }
        return result.toString();



    }
    public static void main(String[] args) {
        String str = "Hello santosh";
        String result = Reverse_String(str);
        System.out.println(result);
        
    }
    
}
