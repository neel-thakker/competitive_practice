import java.util.*;

public class TheCelebrityProblem {

    /*
        A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a
        celebrity in the party or not.
        
        A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it 
        means ith person knows jth person. Here M[i][i] will always be 0.
        
        Note: Follow 0 based indexing.
    */

    // #Efficient!!!!!!!!!!
    static int method2(int arr[][], int n) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0 ; i<n ; i++) {
            st.push(i);
        }
        
        while(st.size()>=2) {
            int a = st.pop(), b = st.pop();
            
            if(arr[a][b]==0)
                st.push(a);
            else
                st.push(b);
        }
        
        int ans = st.peek();
        for(int i=0 ; i<n ; i++)
            if(i!=ans)
                if(arr[i][ans]==0 || arr[ans][i]==1) 
                    return -1; 
    
        return ans;
    }
    
    static int method1(int arr[][], int n) {
        int ans = -1;
        
        for(int i=0 ; i<n ; i++) {
            boolean isHe = true;
            
            for(int j=0 ; j<n ; j++) {
                if(i==j) 
                    continue;
                
                if(arr[j][i]==0) {
                    isHe = false;
                    break;
                }
            }
            
            if(isHe) {
                for(int j=0 ; j<n ; j++) {
                    if(arr[i][j]==1) {
                        isHe = false;
                        break;
                    }   
                }
                
                if(isHe) {
                    ans = i;
                    break;    
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {
            { 0, 1, 0 },
            { 0, 0, 0 },
            { 0, 1, 0 }
        };

        System.out.println(method2(arr, arr.length));
    }
}
