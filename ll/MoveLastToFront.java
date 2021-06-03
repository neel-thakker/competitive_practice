public class MoveLastToFront {

    static Ll.Node moveLastToFront(Ll.Node head) {

        if(head==null || head.next==null) 
            return head;

        Ll.Node temp = head, last = null;

        while(temp.next!=null) {
            if(temp.next.next==null) {
                last = temp.next;
                temp.next = null;
                break;
            }

            temp = temp.next;
        }

        last.next = head;
        
        return last;
    }

    public static void main(String[] args) {
        Ll ll = new Ll();

        Ll.add(ll, 1);
        Ll.add(ll, 2);
        Ll.add(ll, 3);
        Ll.add(ll, 4);
        Ll.add(ll, 5);

        ll.head = moveLastToFront(ll.head);       

        Ll.println(ll);
    }   // end-main
}   // end-class
