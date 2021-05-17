import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = kb.nextInt();

        print_one_to_n(n);
        System.out.println();

        print_n_to_one(n);
        System.out.println();

        System.out.println(factorial(n));
        kb.close();
    } // end-main

    static void print_one_to_n(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }

        print_one_to_n(n - 1);
        System.out.print(n + " ");
    }

    static void print_n_to_one(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        print_n_to_one(n - 1);
    }

    // Home-work
    static long factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
} // end-class