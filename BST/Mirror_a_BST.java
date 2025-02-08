import java.util.*;

public class Mirror_a_BST {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Create mirror of the BST
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively mirror left and right subtrees
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        // Swap the left and right pointers
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // Preorder traversal of the tree
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        // Creating the following BST:
        //     8
        //    / \
        //   5  10
        //  / \   \
        // 3  6    11

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        // Create the mirror of the tree
        root = createMirror(root);

        // Preorder traversal of the mirrored tree
        preorder(root);
    }
}
