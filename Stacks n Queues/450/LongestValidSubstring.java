public class LongestValidSubstring {

    /*
        Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest 
        valid(well-formed) parentheses substring.
    
        NOTE: Length of smallest the valid substring ( ) is 2.
    */

    static int method1(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
    
        int open = 0, close = 0, ans = 0;
        for(int i=0 ; i<n ; i++) {
            if(arr[i] == '(')
                open++;
            else 
                close++;
            
            if(open == close) {
                ans = Math.max(ans, 2*open);
            }
            
            if(close > open) {
                open = 0;
                close = 0;
            }
        }
        
        open = 0;
        close = 0;
        for(int i=n-1 ; i>=0 ; i--) {
            if(arr[i] == '(')
                open++;
            else 
                close++;
            
            if(open == close) {
                ans = Math.max(ans, 2*open);
            }
            
            if(open > close) {
                open = 0;
                close = 0;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        String s = "()(())(";
        
        System.out.println(method1(s));
    }
}