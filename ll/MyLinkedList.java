public class MyLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
    Methods of MyLinkedList Class: 
        .add(MyLinkedList ll, int data);    // addLast
        .addFirst(MyLinkedList ll, int data);
        .addAt(MyLinkedList ll, int index, int data);
        
        .println(MyLinkedList ll);

        .remove(MyLinkedList ll, int key);
        .removeFirst(MyLinkedList ll);
        .removeLast(MyLinkedList ll);
        .removeAt(MyLinkedList ll, int index);
    */

    public static MyLinkedList addFirst(MyLinkedList ll, int data) {
        Node newNode = new Node(data);
        
        newNode.next = ll.head;                // for safety wapis se.
        ll.head = newNode;

        return ll;
    }

    public static MyLinkedList add(MyLinkedList ll, int data) {
        Node newNode = new Node(data);
        newNode.next = null;                // for safety wapis se.

        if(ll.head == null) {
            ll.head = newNode;        
        } else {

            Node temp = ll.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return ll;
    }

    public static MyLinkedList addAt(MyLinkedList ll, int index, int data) {
        Node newNode = new Node(data);

        
        if(ll.head == null) {
            ll.head = newNode;        
        } else if(index == 0){
            newNode.next = ll.head;
            ll.head = newNode;
        } else {

            Node temp = ll.head, prevNode = null;
            int currIndex = 0;
            while(temp != null && currIndex<index) {
                prevNode = temp;
                temp = temp.next;
                currIndex++;
            }

            newNode.next = temp;
            prevNode.next = newNode;
        }

        return ll;
    }

    public static void println(MyLinkedList ll) {
        Node temp = ll.head;

        System.out.print("[");
        while(temp.next != null) {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println(temp.data+"]");
    }

    public static MyLinkedList remove(MyLinkedList ll, int key) {
        // Case 1: Key is found at Head.
        // Case 2: key is found after Head.

        int Index = 0;
        Node currNode = ll.head, prevNode = null;
        if(currNode != null &&  currNode.data == key) {
            ll.head = currNode.next;                                // Now head is pointing to second element.
            System.out.println("Key found at HEAD and deleted.");
        
            return ll;
        }

        // Searching for the element
        while(currNode!=null && currNode.data!=key) {
            prevNode = currNode;
            currNode = currNode.next;
            Index++;
        }

        if(currNode != null) {
            prevNode.next = currNode.next;
            System.out.println("Key is found at index: "+Index+" and deleted.");
        }

        // If element is not present
        if(currNode == null) {
            System.out.println("Element with given key is not found");
        }    

        return ll;
    }

    public static MyLinkedList removeFirst(MyLinkedList ll) {
        if(ll.head==null) {
            System.out.println("List is Empty already.");
        } else {
            ll.head = ll.head.next;
        }
        return ll;
    }

    public static MyLinkedList removeLast(MyLinkedList ll) {
        Node temp = ll.head;

        if(temp==null) {
            System.out.println("List is Empty already.");
        } else {

            while(temp.next.next!=null) {
                temp = temp.next;
            }
            temp.next = null;
        }

        return ll;
    }

    public static MyLinkedList removeAt(MyLinkedList ll, int Index) {
        // Case 1: Key is found at Head.
        // Case 2: key is found after Head.

        int currIndex = 0;
        Node currNode = ll.head, prevNode = null;
        if(currNode != null &&  currIndex == Index) {
            ll.head = currNode.next;                                // Now head is pointing to second element.
            System.out.println("Key found at HEAD and deleted.");
        
            return ll;
        }

        // Searching for the element
        while(currNode!=null && currIndex!=Index) {
            prevNode = currNode;
            currNode = currNode.next;
            currIndex++;
        }

        if(currNode != null && currIndex==Index) {
            prevNode.next = currNode.next;
            System.out.println("Element at index: "+Index+" is deleted.");
        }

        // If element is not present
        if(currNode == null) {
            System.out.println("IndexOutOfBoundException :)");
        }    

        return ll;
    }

    public static void main(String[] args) {
        System.out.println("This is my LinkedList Code.");
    }   // end-main
}   // end-class
