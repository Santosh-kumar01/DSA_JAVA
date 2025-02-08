
import java.util.*;

public class Delete_a_Node  {
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

    public static Node delete(Node root, int val) {
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        
        else if(root.data > val){
            root.left= delete(root.left, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
            
        }
        return root;
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

        root = delete(root, 10);
        System.out.println();

        inorder(root);
    }
}
