import java.util.*;
public class Valid_Anangram {
    public static boolean isAnangram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length();i++){
            char ch = t.charAt(i);

            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
             if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
             }else{
                return false;
             }
        }
        return map.isEmpty();
    }


    public static void main(String[] args) {
        String s = "valid";
        String t = "livad";
        System.out.println(isAnangram(s, t));

    }
    
}
