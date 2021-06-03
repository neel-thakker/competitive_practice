import java.util.*;

public class DetectLoop {

    // Q3 --> whether Loop is present or not in the loop...
    static boolean onlyDetect(Ll.Node head) {

        Ll.Node temp = head;
        Set<Ll.Node> set = new HashSet<>();

        while(temp.next!=null) {
            temp = temp.next;

            if(set.contains(temp)) {
                return true;
            } else {
                set.add(temp);
            }
        }

        return false;
    }

    // Q4 If loop is there then remove it
    static void detectAndRemove(Ll.Node head) {
        Ll.Node temp = head, repeatingNode = null;
        Set<Ll.Node> set = new HashSet<>();

        while(temp.next!=null) {
            temp = temp.next;

            if(set.contains(temp)) {
                repeatingNode = temp;    
                break;
            } 

            set.add(temp);
        }

        temp = head;
        while(temp.next!=null) {
            
            if(temp.next == repeatingNode) {
                temp.next = null;
                break;
            }

            temp = temp.next;
        }
    }

    //Q5 If loop is there then return the first node of the loop
    static Ll.Node findFirstNode(Ll.Node head) {
        Ll.Node temp = head;
        Set<Ll.Node> set = new HashSet<>();
        
        while(temp.next!=null) {
            temp = temp.next;

            if(set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Ll ll = new Ll();
        Ll.Node a1 = new Ll.Node(1), a2 = new Ll.Node(2), a3 = new Ll.Node(3), a4 = new Ll.Node(4); 

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ll.head = a1;
        int ans = 0;

        if(onlyDetect(ll.head)) {
            ans = 1;
            System.out.println("First Node of the Loop:- " + findFirstNode(ll.head).data);
            detectAndRemove(ll.head);
        }

        System.out.println(ans);
        Ll.println(ll);
    }   // end-main 
}   // end-class
