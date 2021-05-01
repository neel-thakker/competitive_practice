import java.util.*;

public class PnWithCaseChange {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String s = kb.nextLine();

        print("", s);

        kb.close();
    } // end-main

    static void print(String ans, String s) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        String ans1 = ans + ("" + s.charAt(0)).toLowerCase(), ans2 = ans + ("" + s.charAt(0)).toUpperCase();
        s = s.substring(1);

        print(ans1, s);
        print(ans2, s);
    }
} // end-class
