import java.util.*;
public class Valid_BST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val); // Correct variable name
        }
        return root;
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); // Left subtree
        System.out.print(root.data + " "); // Root
        inorder(root.right); // Right subtree
    }
    public static boolean isValidBST(Node root, Node min, Node max){
        if (root ==  null) {
            return true;
            
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left, min,root)
                && isValidBST(root.right, root, max);

    }
    public static void main(String[] args) {
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Inorder traversal of the BST
        inorder(root);
        System.out.println();

        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
    
}

}