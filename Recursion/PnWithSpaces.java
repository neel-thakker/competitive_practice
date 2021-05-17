import java.util.*;

public class PnWithSpaces {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        print("" + s.charAt(0), s.substring(1));

        kb.close();
    } // end-main

    static void print(String ans, String s) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        String ans1 = ans + " " + s.charAt(0), ans2 = ans + s.charAt(0);
        s = s.substring(1);

        print(ans1, s);
        print(ans2, s);
    }
} // end-class
