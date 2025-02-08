
import java.util.*;

public class Print_In_Range  {
    // Node class representing a node in the BST
    public static class Node {
        int data;
        Node right; // Correct type: Node
        Node left;  // Correct type: Node

        Node(int data) {
            this.data = data;
        }
    }
    
    // Insert a value into the BST
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

    // Inorder traversal of the BST
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); // Left subtree
        System.out.print(root.data + " "); // Root
        inorder(root.right); // Right subtree
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    

  

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Inorder traversal of the BST
        inorder(root);
        System.out.println();

        printInRange(root, 5, 12);
    }
}
