import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int arr[] = { 1, 0, 5, 2, 9, 8, 9, 7, 4, 1 };
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        delete_middle(stack, stack.size() / 2 + 1);
        System.out.println(stack);
    } // end-main

    static void delete_middle(Stack<Integer> stack, int k) {
        if (stack.isEmpty()) {
            return;
        }

        if (k == 1) {
            stack.pop();
            return;
        }

        int val = stack.pop();
        delete_middle(stack, k - 1);
        stack.push(val);
    }
} // end-class
