import java.util.*;

public class Merge_2_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Get inorder traversal of a BST and store it in the array
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Create a balanced BST from a sorted array
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    // Merge two BSTs into a single balanced BST
    public static Node mergeBSTs(Node root1, Node root2) {
        // Step 1: Get the inorder traversal of both BSTs
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 2: Merge the two sorted arrays
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        // Add remaining elements from arr2
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // Step 3: Convert the merged sorted array back into a balanced BST
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    // Preorder traversal of the BST
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Merge the two BSTs and print the preorder traversal of the new BST
        Node root = mergeBSTs(root1, root2);
        preorder(root);
    }
}

