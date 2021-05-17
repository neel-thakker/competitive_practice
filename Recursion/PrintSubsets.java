import java.util.*;

public class PrintSubsets {

    static boolean dp[][];

    static boolean subsetSum_memozise(List<Integer> arr, int i, int sum) {
        System.out.println("i=" + i + " sum=" + sum);

        if (sum == 0)
            return true;

        if (i > arr.size())
            return false;

        if (dp[i][sum])
            return true;

        if (arr.get(i - 1) <= sum) {
            return dp[i][sum] = (subsetSum_memozise(arr, i + 1, sum - arr.get(i - 1))
                    || subsetSum_memozise(arr, i + 1, sum));
        } else {
            return dp[i][sum] = subsetSum_memozise(arr, i + 1, sum);
        }
    }

    static boolean subsetSum_recursive(List<Integer> arr, int sum) {
        if (sum == 0)
            return true;

        if (arr.size() == 0)
            return false;

        if (arr.get(0) <= sum) {
            return (subsetSum_recursive(arr.subList(1, arr.size()), sum - arr.get(0))
                    || subsetSum_recursive(arr.subList(1, arr.size()), sum));
        } else {
            return subsetSum_recursive(arr.subList(1, arr.size()), sum);
        }
    }

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

    static void print(boolean dp[][]) {

        System.out.println("dp[][]:- ");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine(); // aab

        HashSet<String> set = new HashSet<>();

        // printSubsets("", s);
        printUniqueSubsets("", s, set);

        System.out.println(set);

        // Check if Subset with given sum is present or not ?
        int n = kb.nextInt(), sum = kb.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(kb.nextInt());
        }

        System.out.println(subsetSum_recursive(arr, sum) + "\nMemozisee:-");

        // Check if Subset with given sum is present or not ? (Memozied code)!!
        dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], false);
        }

        System.out.println(subsetSum_memozise(arr, 1, sum));
        print(dp);

        kb.close();
    } // end-main
} // end-class
