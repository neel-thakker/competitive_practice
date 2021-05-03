import java.util.*;

public class Knapsack {

    static int dp[][] = new int[100][100]; // Global Call

    static int memoization(List<Integer> arr, List<Integer> vals, int capacity, int w, int cost) {
        if (arr.size() == 0)
            return cost;

        if (dp[w][cost] != -1) // Checking if already Exists....
            return dp[w][cost];

        int ans1 = recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), capacity, w, cost);

        if (arr.get(0) + w <= capacity) {
            int ans2 = recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), capacity, w + arr.get(0),
                    cost + vals.get(0));

            return dp[w][cost] = Math.max(ans1, ans2); // Storing if it doesn't exists...
        }

        return dp[w][cost] = ans1; // Storing if it doesn't exists...
    }

    static int recursive(List<Integer> arr, List<Integer> vals, int capacity, int w, int cost) {
        if (arr.size() == 0) {
            return cost;
        }

        int ans1 = recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), capacity, w, cost);

        if (arr.get(0) + w <= capacity) {
            int ans2 = recursive(arr.subList(1, arr.size()), vals.subList(1, vals.size()), capacity, w + arr.get(0),
                    cost + vals.get(0));

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

        // System.out.println(recursive(arr, vals, w, 0, 0));

        System.out.println(memoization(arr, vals, w, 0, 0));

        kb.close();
    } // end-main
} // end-class