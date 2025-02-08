import java.util.*;
public class Root_to_Leaf_Path {
    public static class Node{
        int data;
        Node right; 
        Node left;


        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
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
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); // Left subtree
        System.out.print(root.data + " "); // Root
        inorder(root.right); // Right subtree
    }

    public static void printPath(ArrayList<Integer>path){
        for(int i=0; i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer>path){
        if (root == null) {
            return;
            
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);

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

        printRoot2Leaf(root, new ArrayList<>());
    }
    
}
