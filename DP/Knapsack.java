import java.util.*;

public class Knapsack {

    static int dp[][] = new int[100][100]; // Global Call

    static int memoize(List<Integer> arr, List<Integer> vals, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) // Checking if already Exists....
            return dp[n][w];

        int ans1 = memoize(arr.subList(1, arr.size()), vals.subList(1, vals.size()), w, n - 1);

        if (arr.get(0) <= w) {
            int ans2 = vals.get(0)
                    + memoize(arr.subList(1, arr.size()), vals.subList(1, vals.size()), w - arr.get(0), n - 1);

            return dp[n][w] = Math.max(ans1, ans2); // Storing if it doesn't exists...
        }

        return dp[n][w] = ans1; // Storing if it doesn't exists...
    }

    static int recursive(List<Integer> arr, List<Integer> vals, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        int ans1 = recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), w, n - 1);

        if (arr.get(0) <= w) {
            int ans2 = vals.get(0)
                    + recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), w - arr.get(0), n - 1);

            return Math.max(ans1, ans2);
        }

        return ans1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(), w = kb.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>(), vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(kb.nextInt());
            vals.add(kb.nextInt());
        }

        // Filling -1 to whole array!!
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // System.out.println(recursive(arr, vals, w, n));

        System.out.println(memoize(arr, vals, w, n));

        kb.close();
    } // end-main
} // end-class