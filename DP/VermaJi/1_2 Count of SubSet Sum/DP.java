import java.util.*;
// import java.io.*;

public class DP {

    static void print(int arr[][]) {
        System.out.println("Dp Matrix:- ");
        for(int i=0 ; i<arr.length ; i++) {
            for(int j=0 ; j<arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int wt[] = { 2, 3, 5, 8, 10 };
        int n = wt.length, sum = 10;

        int dp[][] = new int[n+1][sum+1];

        Arrays.fill(dp[0], 0);
        for(int i=0 ; i<n+1 ; i++) 
            dp[i][0] = 1;

        for(int i = 1; i < n + 1; i++)
            for(int j = 1; j < sum + 1; j++)
                if(wt[i-1] <= j)
                    dp[i][j] = (dp[i-1][j - wt[i-1]] + dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];

        System.out.println(dp[n][sum]);
        print(dp);

        kb.close();
    }    
}