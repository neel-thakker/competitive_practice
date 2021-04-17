import java.util.*;

public class KthSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), arr[] = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(kthSmallest(arr, 0, n-1, 3));
    }   
    
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        
        int kth[] = new int[k], n = arr.length;
        Arrays.fill(kth, Integer.MAX_VALUE);
        
        for(int i=0 ; i<n ; i++) {
            if(i<k) {
                kth[i] = arr[i];
                continue;
            }

            if(i==k) {
                Arrays.sort(kth);
            }

            if(arr[i]<kth[k-1]) {
                kth[k-1] = arr[i];
                Arrays.sort(kth);
            }
        }

        if(k==n) {
            Arrays.sort(kth);
        }

        return kth[k-1];
    }

}   // end-class
