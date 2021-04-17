import java.util.*;

public class ReverseAString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        System.out.println(reverseWord(s));
    
    }   // end-main

    static String reverseWord(String str) {

        int n = str.length();
        char[] s = new char[n];

        for(int i=0 ; i<n ; i++) {
            s[i] = str.charAt(n-1-i);
        }

        String ans = String.valueOf(s);
        return ans;
    }
}   // end-class