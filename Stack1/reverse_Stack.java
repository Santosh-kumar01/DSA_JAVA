// package Stack1;

import java.util.*;

public class reverse_Stack {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverse_Stack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return; // Base case to stop recursion
        }
        int top = s.pop();
        reverse_Stack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // Stack before reversing: 3, 2, 1

        reverse_Stack(s); // Reverses the stack
        printStack(s);    // Prints the reversed stack
    }
}
