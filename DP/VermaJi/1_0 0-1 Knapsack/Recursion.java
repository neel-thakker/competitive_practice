// import java.io.*;
import java.util.*;

public class Recursion {
    
    static int solve(int w[], int vals[], int cap, int n) {
        if (n == 0 || cap == 0) {
            return 0;
        }

        int ans1 = solve(w, vals, cap, n - 1);
        
        if (w[n-1] <= cap) {
            int ans2 = vals[n-1] + solve(w, vals, cap - w[n-1], n - 1);

            return Math.max(ans1, ans2);
        }

        return ans1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = 4, wt = 7;
        int w[] = {1, 3, 4, 5}, vals[] = {1, 4, 5, 7};
        
        System.out.println(solve(w, vals, wt, n));
        
        kb.close();
    }
}
