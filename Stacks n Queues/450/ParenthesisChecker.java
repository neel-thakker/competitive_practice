import java.util.*;

public class ParenthesisChecker {

    //Function to check if brackets are balanced or not.
    static boolean solve(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        boolean isGood = true;
        
        for(int i=0 ; i<n ; i++) {
            if(arr[i]=='{' || arr[i]=='[' || arr[i]=='(') {
                st.push(arr[i]);
            } else if(st.isEmpty()) {
                isGood = false;
                break;
            }else if(arr[i]=='}') {
                
                if(st.peek()=='{') {
                    st.pop();
                } else {
                    isGood = false;
                    break;
                }
                
            } else if(arr[i]==']') {
                
                if(st.peek()=='[') {
                    st.pop();
                } else {
                    isGood = false;
                    break;
                }
                
            } else if(arr[i]==')') {
                
                if(st.peek()=='(') {
                    st.pop();
                } else {
                    isGood = false;
                    break;
                }
            }
        }
        
        if(!st.isEmpty()) {
            isGood = false;
        } 
        
        return isGood;
    }

    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";

        System.out.println(solve(s));
    }
}
