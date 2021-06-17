import java.util.*;
// import java.io.*;

public class Memoization {

    static int dp[][] = new int[100][100]; // Global Call

    static int solve(int w[], int vals[], int cap, int n) {
        if (n == 0 || cap == 0) {
            return 0;
        }

        if (dp[n][cap] != -1)             // Checking if already Exists....
            return dp[n][cap];

        int ans1 = solve(w, vals, cap, n-1);

        if (w[n-1] <= cap) {
            int ans2 = vals[n-1] + solve(w, vals, cap - w[n-1], n-1);

            return dp[n][cap] = Math.max(ans1, ans2); // Storing if it doesn't exists...
        }

        return dp[n][cap] = ans1; // Storing if it doesn't exists...
    }

    static void print(int arr[][], int n, int m) {
        System.out.println("Dp Matrix:-");
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) 
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = 4, cap = 7;
        int w[] = {1, 3, 4, 5}, vals[] = {1, 4, 5, 7};
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(solve(w, vals, cap, n));
        print(dp, n+1, cap+1);

        kb.close();
    }
}