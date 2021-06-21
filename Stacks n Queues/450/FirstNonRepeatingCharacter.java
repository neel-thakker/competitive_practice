import java.util.*;

public class FirstNonRepeatingCharacter {

    static String method_2(String s) {
        int count[] = new int[26], n = s.length();
        char arr[] = s.toCharArray();
        StringBuffer ans = new StringBuffer();
        
        LinkedList<Character> ll = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++) {
            count[((int) arr[i]) - ((int) 'a')]++;
            ll.add(arr[i]);
            
            while(!ll.isEmpty()) {
                if(count[((int) ll.peek()) - ((int) 'a')] > 1)
                    ll.poll();
                else
                    break;
            }
            
            if(ll.isEmpty()) 
                ans.append("#");
            else 
                ans.append(ll.peek());
        }
        
        return ans.toString();
    }
    
    static String method_1(String s) {
        char arr[] = s.toCharArray();
        int n = s.length(), count[] = new int[26];
        StringBuffer ans = new StringBuffer();
        
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++) {
            q.add(arr[i]);
            count[((int) arr[i]) - ((int) 'a')]++;
            
            while(!q.isEmpty()) {
                if(count[((int) q.peek()) - ((int) 'a')]>1) {
                    q.remove();
                } else 
                    break;
            }
        
            if(q.isEmpty()) {
                ans.append("#");
            } else {
                ans.append(q.peek());
            }
        }
        
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aabc";

        System.out.println(method_2(s));
    }
}
