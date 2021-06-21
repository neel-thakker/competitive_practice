import java.util.*;

public class SortingStack {
    
    static void insertAtCorrectPlace(Stack<Integer> s, int n) {
        if(s.isEmpty()) {
            s.push(n);
            return;
        }
        
        if(s.peek()<n) {
            s.push(n);
            return;
        }
        
        int k = s.pop();
        insertAtCorrectPlace(s, n);
        s.push(k);
    }
    
	static Stack<Integer> sort(Stack<Integer> s) {
		if(s.isEmpty()) 
		    return s; 
		    
        int n = s.pop();
        sort(s);
        insertAtCorrectPlace(s, n);
        
        return s;
	}

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        
        st.push(41);
        st.push(2);
        st.push(32);
        st.push(3);
        st.push(11);

        System.out.println(sort(st));
    }
}
