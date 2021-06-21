import java.util.*;

public class ReverseQueue {

    //Function to reverse the queue.
    static Queue<Integer> rev(Queue<Integer> q){
        if(q.isEmpty())
            return q;
        
        int n = q.poll();
        q = rev(q);
        q.add(n);
    
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);

        System.out.println(rev(q));
    }
}
