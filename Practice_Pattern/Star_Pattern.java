import java.util.*;
public class Star_Pattern {
    public static void Star_Pattern(int n){
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n =4;
        Star_Pattern(n);
    }
  
   
    
}
