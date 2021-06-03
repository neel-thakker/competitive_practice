import java.util.*;

public class RemoveDuplicatesFromLL {

    // Q6
    static void removeDuplicatesInSorted(Ll.Node head) {
        Ll.Node temp = head;

        while(temp.next!=null) {
            if(temp.data == temp.next.data) {
                if(temp.next.next==null) {
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }

                continue;
            }

            temp = temp.next;
        }
    }

    // Q7
    static void removeDuplicatesInUnsorted(Ll.Node head) {
        Ll.Node temp = head;
        Set<Integer> set = new HashSet<>();
        set.add(temp.data);

        while(temp.next!=null) {
            if(set.contains(temp.next.data)) {
                if(temp.next.next==null) {
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
                
                continue;
            } else {
                set.add(temp.next.data);
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Ll ll = new Ll();

        Ll.add(ll, 10);
        Ll.add(ll, 5);
        Ll.add(ll, 100);
        Ll.add(ll, 5);

        // removeDuplicatesInSorted(ll.head);
        removeDuplicatesInUnsorted(ll.head);

        Ll.println(ll);

    }   // end-main
}   // end-class
