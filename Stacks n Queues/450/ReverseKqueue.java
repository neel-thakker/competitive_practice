import java.util.*;

public class ReverseKqueue {

    /*
        Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other 
        elements in the same relative order.

        Only following standard operations are allowed on queue.

        enqueue(x) : Add an item x to rear of queue
        dequeue() : Remove an item from front of queue
        size() : Returns number of elements in queue.
        front() : Finds front item.

    */

    static void reverse(Queue<Integer> q) {
        if(q.isEmpty())
            return;
        
        int n = q.poll();
        reverse(q);
        q.add(n);
    }
    
    static Queue<Integer> method1(Queue<Integer> q, int k) {
        Queue<Integer> ans = new LinkedList<>();    
        int n = q.size();
        
        for(int i=0 ; i<k ; i++) {
            ans.add(q.poll());    
        }
        
        reverse(ans);
        
        for(int i=k ; i<n ; i++) {
            ans.add(q.poll());
        }
        
        return ans;
    }
    
    static Queue<Integer> method2(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<Integer>();
        Queue<Integer> ans = new LinkedList<>();    
        
        for(int i=0 ; i<k ; i++) {
            st.push(q.poll());
        }
        
        while(!st.isEmpty() || !q.isEmpty()) {
            if(!st.isEmpty()) {
                ans.add(st.pop());
                continue;
            }
            
            ans.add(q.poll());
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;
    
        System.out.println(method2(q, k));
    }
}
