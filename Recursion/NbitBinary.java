import java.util.Scanner;

public class NbitBinary {

    static void solve(String ans, int ones, int zeros, int count) {
        if (count == 0) {
            System.out.println(ans);
            return;
        }

        String ans1 = ans + "0", ans2 = ans + "1";

        if (ones == zeros) {
            solve(ans2, ones + 1, zeros, count - 1);
        } else {
            solve(ans1, ones, zeros + 1, count - 1);
            solve(ans2, ones + 1, zeros, count - 1);
        }

    } // end-method

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        solve("", 0, 0, n);

        kb.close();
    }
}
