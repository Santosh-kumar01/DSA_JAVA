import java.util.*;

public class Search_in_a_BST {
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

    // Search for a key in the BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key); // Search in the left subtree
        } else {
            return search(root.right, key); // Search in the right subtree
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Inorder traversal of the BST
        inorder(root);
        System.out.println();

        // Search for a value in the BST
        if (search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}
