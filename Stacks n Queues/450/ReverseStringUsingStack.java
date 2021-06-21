import java.util.*;

public class ReverseStringUsingStack {

    static String reverse(String s){
        char arr[] = s.toCharArray();
        int n = arr.length;
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0 ; i<n ; i++) {
            st.push(arr[i]);
        }
        
        for(int i=0 ; i<n ; i++) {
            arr[i] = st.pop();
        }
        
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "abcdef";

        System.out.println(reverse(s));
    }
}
