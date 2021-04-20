import java.util.*;

public class KthSymbolInGrammar {
    public static void main(String[] args) {

        /**
         * Kth Symbol in Grammar (Leetcode)
         */

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = kb.nextInt();

        System.out.print("Enter k: ");
        int k = kb.nextInt();

        System.out.println(solve(n, (double) k));

        kb.close();
    } // end-main

    static int solve(int n, double k) {
        if (n < 0)
            return -1;

        if (n == 1 && k == 1) {
            return 0;
        }

        int length = power(2, n - 1);
        if (k < 0 || k > length)
            return -1;

        int mid = length / 2;

        if (k <= mid)
            return solve(n - 1, k);
        else {
            int temp = solve(n - 1, k - mid);
            if (temp == 0)
                return 1;
            else
                return 0;
        }
    }

    static int power(int n, int p) {
        if (p == 0)
            return 1;

        return n * power(n, p - 1);
    }
} // end-class
