import java.util.*;

public class GenerateParenthesis {

    static void generateAll(String ans, int open, int close) {
        if (open == 0 && close == 0) {
            System.out.println(ans);
            return;
        }

        String ans1 = ans + "(", ans2 = ans + ")";

        if (open == close) {
            generateAll(ans1, open - 1, close);
        } else if (open == 0) {
            generateAll(ans2, open, close - 1);
        } else {
            generateAll(ans1, open - 1, close);
            generateAll(ans2, open, close - 1);
        }
    } // end-method

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        generateAll("", n, n);

        kb.close();
    } // end-main
} // end-class
