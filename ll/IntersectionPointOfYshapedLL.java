import java.util.*;

public class IntersectionPointOfYshapedLL {

    // Time: O(n*m), Size: O(1)
    // loop ke ander loop (sabse noob approach)
    static int intersectionPoint_method1(Ll.Node head1, Ll.Node head2) {
        Ll.Node curr = head1;
        int ans = -1;
        
        while(curr!=null) {
            if(ans!=-1) {
                break;
            }

            Ll.Node temp = head2;
            while(temp!=null) {
                if(temp==curr) {
                    ans = temp.data;
                    break;
                }

                temp = temp.next;
            }

            curr = curr.next;
        }


        return ans;
    }

    // //  Time: O(n+m), Space: O(n)
    // By storing the addresses of all nodes in a string
    // Replacement of hashing (kind of)
    static int intersectionPoint_method2(Ll.Node head1, Ll.Node head2) {
        Ll.Node temp = head1;
        int ans = -1;
        String s = "";
        
        while(temp!=null) {
            s += temp+" ";
            temp = temp.next;
        }

        temp = head2;
        while(temp!=null) {
            if(s.contains(temp+"")) {
                ans = temp.data;
                break;
            }

            temp = temp.next;
        }

        return ans;
    }

    //  Time: O(n+m), Space: O(n) 
    // Hashing  
    static int intersectionPoint_method3(Ll.Node head1, Ll.Node head2) {
        Ll.Node temp = head1;
        int ans = -1;
    
        Set<Ll.Node> set = new HashSet<>();
        
        while(temp!=null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = head2;
        while(temp!=null) {
            if(set.contains(temp)) {
                ans = temp.data;
                break;
            }

            temp = temp.next;
        }

        return ans;
    }

    // Coooooolest Approach!!
    // Time: O(n+m), Size: O(1)
    static int intersectionPoint_coolestApproah(Ll.Node head1, Ll.Node head2) {
        Ll.Node temp = head1;
        int ans = -1, n = 0, m = 0;
        
        while(temp!=null) {
            n++;
            temp = temp.next;
        }

        temp = head2;
        while(temp!=null) {
            m++;
            temp = temp.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        Ll.Node head1 = null, 
                head2 = null,
                a1 = new Ll.Node(3),
                a2 = new Ll.Node(6),
                a3 = new Ll.Node(9),
                common = new Ll.Node(15),
                a5 = new Ll.Node(30),

                b1 = new Ll.Node(2),
                b2 = new Ll.Node(10);
        
        head1 = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = common;
        common.next = a5;
        
        head2 = b1;
        b1.next = b2;
        b2.next = common;
        
        System.out.println(intersectionPoint_coolestApproah(head1, head2));
    }    
}
