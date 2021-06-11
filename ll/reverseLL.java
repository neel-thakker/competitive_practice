public class reverseLL {

    // Q2
    static Ll.Node reverseInGroup(Ll.Node head, int k) {
        Ll.Node prev = null, temp = null, nextNode = head, start = head, end = null;
        int count = 0;
        boolean headNotDone = true, IsContinue = true;

        while(IsContinue) {
            if(nextNode==null) {
                IsContinue = false;
                count = k;
            }

            if(count==k) {
                start.next = nextNode;
                prev = null;

                if(headNotDone) {
                    head = temp;
                    headNotDone = false;
                } else {
                    end.next = temp;
                }
                
                end = start;
                start = nextNode;
                count = 0;
                continue;
            }

            temp = nextNode;
            nextNode = nextNode.next;
            temp.next = prev;
            prev = temp;

            count++;
        }
        
        return head;
    }

    // Q1
    // Iterative method
    static Ll.Node reverse_iterative(Ll.Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Ll.Node prev = null, temp = null, nextNode = head;

        while(nextNode != null) {
            if(nextNode.next==null) {   // IMP block
                nextNode.next = temp; 
                head = nextNode;
                break;
            }

            temp = nextNode;
            nextNode = nextNode.next;       // imp to keep it here and not in the end of the loop, coz of heap management
            temp.next = prev;
            prev = temp;
        }
        
        return head;
    }

    // Q1
    // Recursive method
    static Ll.Node reverse_recursive(Ll.Node head, Ll.Node tail) {
        if(head.next==null) {
            return head;
        }
        
        Ll.Node newHead = reverse_recursive(head.next, tail);
        head.next = null;

        // // Adding temp at the end of the obtained ll(head),
        // Ll.Node curr = head;
        // if(curr.next==null) {
        //     curr.next = temp;
        // } else {
        //     while(curr.next!=null) {
        //         curr = curr.next;
        //     }

        //     curr.next = temp;
        // }
                
        return newHead;
    }

    public static void main(String[] args) {

        Ll ll = new Ll();
        Ll.add(ll, 5);
        Ll.add(ll, 4);
        Ll.add(ll, 3);
        Ll.add(ll, 2);
        Ll.add(ll, 1);

        Ll.println(ll);
        System.out.println("Head:- " + ll.head.data);

        // ll.head = reverse_recursive(ll.head);

        Ll.println(ll);
        System.out.println("Head:- " + ll.head.data + "\n\nSecond Question:-");

        /** 2nd Question */
        Ll.add(ll, 6);
        Ll.add(ll, 7);
        Ll.add(ll, 8);
        Ll.add(ll, 9);

        Ll.println(ll);
        System.out.println("Head:- " + ll.head.data);

        ll.head = reverseInGroup(ll.head, 3);

        Ll.println(ll);
        System.out.println("Head:- " + ll.head.data);

    }   // end-main
}   // end-class
