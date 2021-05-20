public class reverseLL {

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

    public static void main(String[] args) {

        Ll ll = new Ll();
        Ll.add(ll, 5);
        Ll.add(ll, 4);
        Ll.add(ll, 3);
        Ll.add(ll, 2);
        Ll.add(ll, 1);

        Ll.println(ll);
        System.out.println("Head:- " + ll.head.data);

        Ll.Node curr = ll.head, b4 = null;
        while(ll.head.next != null) {
            curr = ll.head;
            ll.head = ll.head.next;
            curr.next = b4;
            b4 = curr;
        }

        ll.head.next = curr;           // IMP Line 

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
