public class Ll {

    public Node head;

    static class Node {
        int data;
        Node next;

        int flag;       // Replacement of Hashing in many cases :)

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
    Methods of Ll Class: 
        .add(Ll ll, int data);    // addLast
        .addFirst(Ll ll, int data);
        .addAt(Ll ll, int index, int data);
        
        .println(Ll ll);

        .remove(Ll ll, int key);
        .removeFirst(Ll ll);
        .removeLast(Ll ll);
        .removeAt(Ll ll, int index);
    */

    public static Ll addFirst(Ll ll, int data) {
        Node newNode = new Node(data);
        
        newNode.next = ll.head;                // for safety wapis se.
        ll.head = newNode;

        return ll;
    }

    public static Ll add(Ll ll, int data) {
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

    public static Ll addAt(Ll ll, int index, int data) {
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

    public static void println(Ll ll) {
        Node temp = ll.head;

        System.out.print("[");
        while(temp.next != null) {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println(temp.data+"]");
    }

    public static Ll remove(Ll ll, int key) {
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

    public static Ll removeFirst(Ll ll) {
        if(ll.head==null) {
            System.out.println("List is Empty already.");
        } else {
            ll.head = ll.head.next;
        }
        return ll;
    }

    public static Ll removeLast(Ll ll) {
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

    public static Ll removeAt(Ll ll, int Index) {
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
