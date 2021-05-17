import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        System.out.println("Pehle :- " + stack);
        reverse(stack);
        System.out.println("Baadme:- " + stack);
    } // end-main

    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        if (stack.size() == 1)
            return;

        int val = stack.pop();
        reverse(stack);
        push_bottom(stack, val);
    }

    static void push_bottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();
        push_bottom(stack, val);
        stack.push(temp);
    }
} // end-class
