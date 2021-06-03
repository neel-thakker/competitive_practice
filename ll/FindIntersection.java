import java.util.*;

public class FindIntersection {

    /*
        This Method will return the head of new LinkedList which contains
        the common elements (Intersection of both lls) of both LLs

        Note: It is given that both LLs are SORTED in the begining
    */

    // By Hashing
    static Ll.Node findIntersection_method1(Ll.Node head1, Ll.Node head2) {
        Ll.Node temp = head1;
        Set<Integer> set = new HashSet<>();

        while(temp!=null) {
            set.add(temp.data);
            temp = temp.next;
        }

        Ll.Node ans = null;

        temp = head2;
        while(temp!=null) {
            if(set.contains(temp.data)) {
                set.remove(temp.data);

                if(ans==null) {
                    ans = new Ll.Node(temp.data);
                } else {
                    Ll.Node curr = ans;

                    while(curr.next!=null) {
                        curr = curr.next;
                    }

                    curr.next = new Ll.Node(temp.data);
                }
            }
            
            temp = temp.next;
        }

        return ans;
    }
 
    // By using the fact that they are sorted
    static Ll.Node findIntersection_method2(Ll.Node head1, Ll.Node head2) {
        Ll.Node temp1 = head1, temp2 = head2, ans = null;

        while(temp1!=null && temp2!=null) {
            if(temp1.data == temp2.data) {
                
                if(ans==null) {
                    ans = new Ll.Node(temp1.data);
                } else {
                    Ll.Node temp = ans;

                    while(temp.next!=null) {
                        temp = temp.next;
                    }

                    temp.next = new Ll.Node(temp1.data);
                }

                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if(temp1.data < temp2.data) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Ll ll1 = new Ll(), ll2 = new Ll(), ll3 = new Ll();
        
        Ll.add(ll1, 1);
        Ll.add(ll1, 2);
        Ll.add(ll1, 3);
        Ll.add(ll1, 4);
        Ll.add(ll1, 6);

        Ll.add(ll2, 2);
        Ll.add(ll2, 4);
        Ll.add(ll2, 6);
        Ll.add(ll2, 8);

        ll3.head = findIntersection_method2(ll1.head, ll2.head);       

        Ll.println(ll3);
    }    // end-main
}   // end-class
