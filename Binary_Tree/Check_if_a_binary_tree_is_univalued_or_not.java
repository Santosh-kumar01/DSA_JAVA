import java.util.*;

public class Check_if_a_binary_tree_is_univalued_or_not {
static  class Node{
    int data;
    Node left;
    Node right;

}; 
static Node newNode(int data){
    Node temp = new Node();
    temp.data = data;
    temp.left = temp.right = null;
    return(temp);
}

static boolean isUnivalTree(Node root){
    if(root == null){
        return true;
    }
    if(root.left!=null && root.data != root.left.data)
    return false;


    if(root.left!=null && root.data != root.right.data)
    return false;

    return isUnivalTree(root.left) && isUnivalTree(root.right);
}
public static void main(String[] args) {
    Node root = newNode(2);
    root.left= newNode(2);
    root.right = newNode(2);
    root.left.left = newNode(5);
    root.left.right = newNode(2);
    // root.right.right = newNode(1);

    if(isUnivalTree(root)){
        System.out.print("YES");
    }
    else{
        System.out.print("NO");
    }
}  
}
