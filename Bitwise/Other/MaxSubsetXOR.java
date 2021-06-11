package Other;

class MaxSubsetXOR {
    
    public static int maxSubarrayXOR(int arr[]) {
        int index = 0, n  = arr.length;
        
        for(int i=31 ; i>=0 ; i--) {
            int maxInd = index, maxEle = Integer.MIN_VALUE;
            
            //finding the max element with i'th bit set, checking from index to n
            for(int j=index ; j<n ; j++) {
                if((arr[j]&(1<<i))!=0 && arr[j]>maxEle) {
                    maxEle = arr[j];
                    maxInd = j;
                }
            }
            
            // check (i-1)th bit if not found
            if(maxEle==Integer.MIN_VALUE)
                continue; 
            
            // Swapping the maxEle to make it at arr[index]
            int temp = arr[index];
            arr[index] = arr[maxInd];
            arr[maxInd] = temp;
            
            maxInd = index;
            index++;
            
            // Doing XOR of all the rest of the elements having ith bit set with maxEle
            for(int j=0 ; j<n ; j++)
                if((arr[j]&(1<<i))!=0 && j!=maxInd)
                    arr[j] ^= arr[maxInd];
        }
        
        int ans = 0;
        for(int i=0 ; i<n ; i++)
            ans ^= arr[i];
        
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 5};
        System.out.println(maxSubarrayXOR(arr));
    }
}