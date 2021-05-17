import java.util.*;

public class Program2_2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int arr[] = { 1, 0, 5, 2, 9, 8, 9, 7, 4, 1 };
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        sort(stack);
        System.out.println(stack);
    } // end-main

    static void sort(Stack<Integer> stack) {
        if (stack.size() == 1)
            return;

        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    static void insert(Stack<Integer> stack, int temp) {
        if (stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }
} // end-class
