import java.util.*;

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();      // not compulsory to use....
    
    //Function to push an element into stack using two queues.
    void push(int a) {
        if(q1.isEmpty() && !q2.isEmpty()) {
            q2.add(a);
        } else {
            q1.add(a);
        }
    }
    
    //Function to pop an element from stack using two queues. 
    int pop1() {
        if(q1.isEmpty() && q2.isEmpty())
            return -1;
        
        if(q2.isEmpty()) {
            while(q1.size()>1) 
    	        q2.add(q1.remove());
    	        
    	    return q1.remove();    
        }
        
        while(q2.size()>1) 
	        q1.add(q2.remove());
	        
	    return q2.remove();
    }
    
    int pop2() {
        if(q1.isEmpty())
            return -1;
        
        int n = q1.size();
        for(int i=0 ; i<n-1 ; i++) 
            q1.add(q1.poll());
    
        return q1.poll();
    }
	
}

public class StackUsingQueue {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
