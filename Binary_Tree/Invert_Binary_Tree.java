import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Invert_Binary_Tree {
    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null)
            return node;

        // Recursively call mirror for left and right subtrees
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        // Swap the left and right subtrees
        node.left = right;
        node.right = left;

        return node;
    }

    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Invert_Binary_Tree tree = new Invert_Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

    
        System.out.println("Inorder traversal of input tree is:");
        tree.inOrder();
        System.out.println("");

        tree.mirror();

        System.out.println("Inorder traversal of mirrored tree is:");
        tree.inOrder();
    }
}
