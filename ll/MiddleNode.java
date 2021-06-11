public class MiddleNode {

    static Ll.Node middleNode(Ll.Node head) {
        int n = 0, m = 0;
        Ll.Node temp = head;
        while(temp!=null) {
            n++;
            temp = temp.next;
        }

        System.out.println(n);
        
        temp = head;
        while(temp!=null) {
            if(m >= n/2) {
                break;
            }
            
            m++;
            temp = temp.next;
        }
        
        return temp;
    }

    public static void main(String[] args) {
        Ll.Node head1 = null, 
                head2 = null,
                a1 = new Ll.Node(3),
                a2 = new Ll.Node(4),
                a3 = new Ll.Node(5),

                b1 = new Ll.Node(4),
                b2 = new Ll.Node(5);
        
        head1 = a1;
        a1.next = a2;
        a2.next = a3;

        head2 = b1;
        b1.next = b2;

        System.out.println(middleNode(head1).data);
    }    
}
