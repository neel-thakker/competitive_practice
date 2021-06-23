import java.util.*;

public class NGE {

    /*
        Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the 
        array in order of their appearance in the array.
        
        Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
        If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater 
        of the last element is always -1.
    */ 

    //Function to find the next greater element for each element of the array.
    public static int[] nextLargerElement(int[] arr, int n) { 
        int ans[] = new int[n];
        
        Stack<Integer> st = new Stack<Integer>();
        for(int i=n-1 ; i>=0 ; i--) {
            ans[i] = -1;
            
            while(!st.isEmpty()) {
                if(st.peek() > arr[i]) {
                    ans[i] = st.peek();
                    break;
                }
                
                st.pop();
            }
        
            st.push(arr[i]);
        }
        
        return ans;
    } 

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };

        int ans[] = nextLargerElement(arr, arr.length);
        for(int i=0 ; i<ans.length ; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
