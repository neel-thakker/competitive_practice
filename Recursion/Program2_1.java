import java.util.*;

public class Program2_1 {
    public static void main(String[] args) {

        /**
         * A Recursive program to sort an array. This program includes a small recursive
         * function insert to insert an element at its correct place.
         */

        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 0, 5, 2, 9, 8, 9, 7, 4, 1));

        sort(arr);

        System.out.println(arr);
    } // end-main

    static void sort(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return;

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sort(arr);
        insert(arr, temp);
    }

    static void insert(ArrayList<Integer> arr, int temp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);
            return;
        }

        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);
    }
} // end-class
