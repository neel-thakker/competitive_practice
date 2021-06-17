import java.util.*;

public class DP {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = 4, cap = 7;
        int w[] = {1, 3, 4, 5}, vals[] = {1, 4, 5, 7};

        int dp[][] = new int[n + 1][cap + 1];

        // Initialization of Table (from the Base condition of recursive approach)
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= n; i++)
            dp[0][i] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < cap + 1; j++)
                if (w[i - 1] <= j)
                    dp[i][j] = Math.max(vals[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                else 
                    dp[i][j] = dp[i - 1][j];

        System.out.println(dp[n][cap]);

        kb.close();
    } // end-main
} // end-class
