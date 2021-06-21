import java.util.*;

public class GameWithStrings {

    /*
        Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal 
        of ‘k’ characters. The value of a string is defined as the sum of squares of the count of each distinct character.
    */

    static int minValue(String s, int k){
        int n = s.length();
        int count[] = new int[26];
        
        for(int i=0 ; i<n ; i++) {
            count[ ((int) s.charAt(i)) - ((int) 'a') ]++;
        }
        
        while(k>0) {
            Arrays.sort(count);
            count[25]--;
            k--;
        }
        
        // for(int i=25 ; i>=0 ; i--) {
        //     System.out.print(count[i]+" ");
        // }
        // System.out.println();
        
        int ans = 0;
        for(int i=0 ; i<26 ; i++) {
            ans += count[i]*count[i];
        }
        
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcbcbcabcc";
        int k = 3;

        System.out.println(minValue(s, k));
    }
}
