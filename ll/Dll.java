public class Dll {
    public Node head, tail;

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public static Dll add(Dll dll, int d) {
        Node newNode = new Node(d);

        if(dll.tail==null) {
            dll.head = newNode;
            dll.tail = newNode;
        } else {
            dll.tail.next = newNode;
            dll.tail = dll.tail.next;
        }

        return dll;
    }
}
