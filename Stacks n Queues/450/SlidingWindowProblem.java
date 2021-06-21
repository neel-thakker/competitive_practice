import java.util.*;

public class SlidingWindowProblem {

    static long[] printFirstNegativeInteger(long arr[], int n, int k) {
        long[] ans = new long[n-k+1];
        int p = 0;
        Queue<Long> q = new LinkedList<>();
        
        for(int i=0 ; i<k ; i++)
            if(arr[i]<0)
                q.add(arr[i]);
        
        ans[0] = q.isEmpty() ? 0 : q.peek();
        
        for(int i=k ; i<n ; i++) {
            p++;
            
            if(arr[i]<0)
                q.add(arr[i]);
            
            if(!q.isEmpty() && q.peek()==arr[i-k])
                q.poll();
                
            ans[p] = q.isEmpty() ? 0 : q.peek();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        long arr[] = {-8, 2, 3, -6, 10};
        int k = 2;

        long ans[] = printFirstNegativeInteger(arr, arr.length, k);
        for(int i=0 ; i<ans.length ; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
