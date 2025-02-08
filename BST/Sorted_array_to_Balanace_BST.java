
import java.util.*;

public class Sorted_array_to_Balanace_BST {
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
    public static Node createBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};

        // Creating the following BST:
        //     8
        //    / \
        //   5  10
        //  / \   \
        // 3  6    11


       Node root = createBST(arr, 0, arr.length-1);
       preorder(root);
    }
}
