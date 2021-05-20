public class reverseLL {

    static MyLinkedList.Node reverseInGroup(MyLinkedList.Node head, int k) {
        MyLinkedList.Node prev = null, temp = null, nextNode = head, start = head, end = null;
        int count = 0;
        boolean headNotDone = true, IsContinue = true;

        while(IsContinue) {

            if(nextNode==null) {
                IsContinue = false;
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

        MyLinkedList ll = new MyLinkedList();
        MyLinkedList.add(ll, 5);
        MyLinkedList.add(ll, 4);
        MyLinkedList.add(ll, 3);
        MyLinkedList.add(ll, 2);
        MyLinkedList.add(ll, 1);

        MyLinkedList.println(ll);
        System.out.println("Head:- " + ll.head.data);

        MyLinkedList.Node curr = ll.head, b4 = null;
        while(ll.head.next != null) {
            curr = ll.head;
            ll.head = ll.head.next;
            curr.next = b4;
            b4 = curr;
        }

        ll.head.next = curr;           // IMP Line 

        MyLinkedList.println(ll);
        System.out.println("Head:- " + ll.head.data + "\n\nSecond Question:-");

        /** 2nd Question */
        MyLinkedList.add(ll, 6);
        MyLinkedList.add(ll, 7);
        MyLinkedList.add(ll, 8);
        MyLinkedList.add(ll, 9);

        MyLinkedList.println(ll);
        System.out.println("Head:- " + ll.head.data);

        ll.head = reverseInGroup(ll.head, 3);

        MyLinkedList.println(ll);
        System.out.println("Head:- " + ll.head.data);

    }   // end-main
}   // end-class
