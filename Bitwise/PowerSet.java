import java.util.*;

public class PowerSet {

    static List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        char arr[] = s.toCharArray();
        
        for(int i=1 ; i<=Math.pow(2, n)-1 ; i++) {
            String str = "";
            for(int j=0 ; j<n ; j++) {
                if((i&(1<<j))>0) {
                    str += arr[j];
                }
            }

            ans.add(str);
        }
        
        Collections.sort(ans);
        
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = AllPossibleStrings(s);

        for(int i=0 ; i<ans.size() ; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }    
}
