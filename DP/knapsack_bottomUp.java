import java.util.*;

public class knapsack_bottomUp {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(), w = kb.nextInt();

        int wt[] = new int[n], vals[] = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = kb.nextInt();
        }

        for (int i = 0; i < n; i++) {
            vals[i] = kb.nextInt();
        }

        int dp[][] = new int[n + 1][w + 1];

        // Initialization of Table (from the Base condition of recursive approach)
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= n; i++)
            dp[i][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(vals[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][w]);

        kb.close();
    } // end-main

    static void print(int dp[][]) {
        System.out.println("Dp:-");

    }
} // end-class
