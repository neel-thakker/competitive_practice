import java.util.*;

public class PrintSubsets {

    static void printUniqueSubsets(String ans, String s, HashSet<String> set) {
        if (s.length() == 0) {
            set.add(ans);
            // if (!set.contains(ans)) {
            // // System.out.println(ans);
            // set.add(ans);
            // }
            return;
        }

        String ans2 = ans + s.charAt(0);
        s = s.substring(1);

        printUniqueSubsets(ans, s, set);
        printUniqueSubsets(ans2, s, set);
    }

    static void printSubsets(String ans, String s) {
        if (s.length() == 0) {
            System.out.println(ans);
            return; // yeh likhna matt bhulna (segmentation fault)
        }

        String ans2 = ans + s.charAt(0);
        s = s.substring(1);

        printSubsets(ans, s);
        printSubsets(ans2, s);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        HashSet<String> set = new HashSet<>();

        // printSubsets("", s);

        printUniqueSubsets("", s, set);
        System.out.println(set);

        kb.close();
    } // end-main
} // end-class
