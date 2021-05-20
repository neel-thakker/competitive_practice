import java.util.*;

public class KadanesAlgo {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        int n = kb.nextInt(), arr[] = new int[n], best = Integer.MIN_VALUE, sum = 0;
        
        for(int i=0 ; i<n ; i++) {
            arr[i] = kb.nextInt();
            
            // MAIN ALGO
            sum = Math.max(arr[i], sum+arr[i]);
            best = Math.max(best, sum);
        }

        System.out.println("Maximum sum of a contiguous sub-array is:- "+best);

        kb.close();
    }   // end-main
}   // end-class