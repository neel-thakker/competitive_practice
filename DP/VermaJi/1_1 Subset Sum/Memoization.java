import java.util.*;
// import java.io.*;

public class Memoization {

    static boolean dp[][] = new boolean[100][100];

    static boolean solve(int arr[], int n, int sum, String s) { 
        if(sum == 0) {
            System.out.println(s);
            return true;
        }   
        
        if(n == 0 || sum < 0)
            return false;

        if(dp[n][sum])
            return dp[n][sum];

        return dp[n][sum] = solve(arr, n-1, sum, s) || solve(arr, n-1, sum - arr[n-1], s + arr[n-1] + " ");
    } 

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int wt[] = { 2, 3, 7, 8, 10 };
        int n = wt.length, sum = 9;

        for(int i = 0; i < n + 1; i++)
            for(int j = 0; j < sum + 1; j++)
                dp[i][j] = false;

        System.out.println(solve(wt, n, sum, ""));

        kb.close();
    }    
}
