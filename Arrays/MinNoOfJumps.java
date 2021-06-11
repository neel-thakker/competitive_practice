import java.util.Arrays;

public class MinNoOfJumps {

    static int dp[] = new int[10000000];

    static int solve(int arr[], int i) {
        if(i>=arr.length-1) {
            return 0;
        }

        int min = Integer.MAX_VALUE-1;

        if(dp[i]!=0) {
            min = dp[i];
        } else {
            for(int j=1 ; j<=arr[i] ; j++) {
                int temp;
                if(arr[i] == 0) {
                    temp = Integer.MAX_VALUE;
                } else {
                    temp = 1 + solve(arr, i+j);
                }
                
                min = Math.min(min, temp);
            }

            dp[i] = min;
        }

        return min;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};

        Arrays.fill(dp, 0);

        System.out.println(solve(arr, 0));
    }
}