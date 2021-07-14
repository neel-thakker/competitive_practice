import java.util.*;
// import java.io.*;

public class DP {

    static void print(boolean arr[][]) {
        System.out.println("Dp Matrix:- ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j])
                    System.out.print("true  ");
                else
                    System.out.print("false ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int wt[] = { 1, 6, 11, 5 };
        int n = wt.length, sum = 23, ans = sum;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        Arrays.fill(dp[0], false);
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = true;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j++)
                if (wt[i - 1] <= j)
                    dp[i][j] = (dp[i - 1][j - wt[i - 1]] || dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];

        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n][i]) {
                ans = sum - 2 * i;
                break;
            }
        }

        System.out.println(ans);
        print(dp);

        kb.close();
    }
}