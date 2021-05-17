import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        solve("Source Rod", "Destination Rod", "Helper Rod", n);

        kb.close();
    } // end-main

    static void solve(String s, String d, String h, int n) {
        if (n == 1) {
            System.out.println("Moving plate no." + n + " from " + s + " to " + d);
            return;
        }

        solve(s, h, d, n - 1);

        System.out.println("Moving plate no." + n + " from " + s + " to " + d);

        solve(h, d, s, n - 1);
    } // end-solve
} // end-class
