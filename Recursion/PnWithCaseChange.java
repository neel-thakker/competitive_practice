import java.util.*;

public class PnWithCaseChange {

    static void letterCasePn(String ans, String s, HashSet<String> set) {
        if (s.length() == 0) {
            if (!set.contains(ans)) {
                System.out.println(ans);
                set.add(ans);
            }
            return;
        }

        String ans1 = ans + ("" + s.charAt(0)).toLowerCase(), ans2 = ans + ("" + s.charAt(0)).toUpperCase();
        s = s.substring(1);

        letterCasePn(ans1, s, set);
        letterCasePn(ans2, s, set);
    }

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

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String s = kb.nextLine();
        HashSet<String> set = new HashSet<>();

        // print("", s);
        letterCasePn("", s, set);

        kb.close();
    } // end-main
} // end-class
