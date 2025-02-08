import java.util.*;

public class Longest_word_with_all_prefix {
    static class Node {
        Node[] children = new Node[26];
        boolean eow; // End of Word

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    public static Node root = new Node();
    public static List<String> longestWords = new ArrayList<>();
    public static int maxLength = 0;

    // Insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Mark the end of the word
    }

    // Function to find the longest words with all prefixes in the Trie
    public static void findLongestWords(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                if (temp.length() > maxLength) {
                    maxLength = temp.length();
                    longestWords.clear(); // Clear previous words of shorter length
                    longestWords.add(temp.toString());
                } else if (temp.length() == maxLength) {
                    longestWords.add(temp.toString());
                }

                findLongestWords(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        // Input list of words
        String words[] = {"a", "banana", "app", "ap", "apple", "apply"};

        // Insert words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Find the longest words with all prefixes
        findLongestWords(root, new StringBuilder());

        // Print the result
        System.out.println("Longest word(s) with all prefixes: " + longestWords);
    }
}