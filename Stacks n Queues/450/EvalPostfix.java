import java.util.*;

public class EvalPostfix {

    /*
        Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. 
        Operators will only include the basic arithmetic operators like *, /, + and -.
    */

    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s) {
        Stack<Integer> st = new Stack<Integer>();
        char arr[] = s.toCharArray();
        int n = arr.length;
        
        for(int i=0 ; i<n ; i++) {
            if(arr[i]=='+') {
                
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
                // ans += a+b;
                
            } else if(arr[i]=='-') {
                
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);               // Order matters BC!!
                // ans += a-b;
                
            } else if(arr[i]=='*') {
                
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
                // ans += a*b;
                
            } else if(arr[i]=='/') {
                
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);               // Order matters BC!!
                // ans += a/b;
                
            } else {
                st.add( ((int) arr[i]) - ((int) '0') );
            }
        }
        
        return st.peek();
    }

    public static void main(String[] args) {
        String s1 = "231*+9-";       // ans = -4
        String s2 = "123+*8-";      // ans = -3     
    
        System.out.println(evaluatePostFix(s1) + " " + evaluatePostFix(s2));
    }
}
