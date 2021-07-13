import java.util.*;

public class Dp02Knapsack {

    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) { 
        int dp[][] = new int[n+1][w+1];
        
        Arrays.fill(dp[0], 0);
        for(int i=1 ; i<n ; i++)
            dp[i][0] = 0;
        
        for(int i=1 ; i<n+1 ; i++)
            for(int j=1 ; j<w+1 ; j++)
                if(wt[i-1]<=j)
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
             
        return dp[n][w];   
    } 

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = 4, cap = 7;
        int w[] = {1, 3, 4, 5}, val[] = {1, 4, 5, 7};

        System.out.println(knapSack(cap, w, val, n));

        kb.close();
    }
}
