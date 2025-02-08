public class BuildBST {
    static class Node {
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
            // Right subtree
            root.right = insert(root.right, val); // Fixed the variable name
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
    }
}
