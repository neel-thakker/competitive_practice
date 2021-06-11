public class NonRepeatingNumbers {

    /*
        All the bits that are set in xor will be set in one non-repeating element (x or y) and not in others.
        So if we take any set bit of xor and divide the elements of the array in two sets – one set of elements with
        same bit set and another set with same bit not set. By doing so, we will get x in one set and y in another set.
        Now if we do XOR of all the elements in the first set, we will get the first non-repeating element, and by
        doing same in other sets we will get the second non-repeating element. 
    */

    static int[] singleNumber(int arr[]) {
        int sum = 0, n = arr.length;
        
        for(int i=0 ; i<n ; i++) {
            sum = (sum^arr[i]);
        }
        
        sum = (sum&(-sum));
        
        int sum1 = 0, sum2 = 0;
        
        for(int i=0 ; i<n ; i++) {
            if((arr[i]&sum)>0) {
                sum1 = (sum1^arr[i]);
            } else {
                sum2 = (sum2^arr[i]);
            }
        }
        
        int ans[] = new int[2];
        ans[0] = Math.min(sum1, sum2);
        ans[1] = Math.max(sum1, sum2);
        
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 4};

        int ans[] = singleNumber(arr);
        for(int i=0 ; i<2 ; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }   // end-main
}   // end-class
