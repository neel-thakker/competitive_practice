public class AddTwoNumbers {

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

    static Ll.Node addTwoLists_method1(Ll.Node first, Ll.Node second){
        first = reverse_iterative(first);
        second = reverse_iterative(second);
        
        Ll.Node temp1 = first, temp2 = second, head = new Ll.Node(-1), temp = head;
        int carry = 0, flag = 1;
        while(temp1!=null || temp2!=null) {
            if(temp1 == null) {
                int d = temp2.data + carry;
                temp.next = new Ll.Node(d%10);
                carry = d/10;
            
                temp = temp.next;
                temp2 = temp2.next;
                continue;
            }
            
            if(temp2 == null) {
                int d = temp1.data + carry;
                temp.next = new Ll.Node(d%10);
                carry = d/10;
                
                temp = temp.next;
                temp1 = temp1.next;
                continue;
            }
            
            System.out.println("HI");

            int d = temp1.data + temp2.data + carry;
            temp.next = new Ll.Node(d%10);
            carry = d/10;

            if(flag>0) {
                head = temp;
                flag = 0;
            }

            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return reverse_iterative(head.next);
    }

    static Ll.Node addTwoLists_method2(Ll.Node first, Ll.Node second) {
        int a = 0, b = 0, p = 0, n = 0, m = 0;

        Ll.Node temp = first;
        while(temp != null) {
            n++;
            temp = temp.next;
        }

        temp = second;
        while(temp != null) {
            m++;
            temp = temp.next;
        }

        temp = first;n--;
        while(temp!=null) {
            a += temp.data*Math.pow(10, n);
            n--;
            temp = temp.next;
        }

        temp = second;m--;
        while(temp!=null) {
            b += temp.data*Math.pow(10, m);
            m--;
            temp = temp.next;
        }

        a = a+b;
        n = (int) Math.log10(a);
        p = (int) Math.pow(10, n);
        Ll.Node head = new Ll.Node(a/p);
        a = a%p;

        temp = head;
        while(n>=1) {
            n--;
            p = (int) Math.pow(10, n);

            temp.next = new Ll.Node(a/p);
            a = a%p;
            temp = temp.next;
        }

        return head;
    }

    static Ll.Node addTwoLists_method3(Ll.Node first, Ll.Node second) {
        int p = 0, n = 0, m = 0;

        Ll.Node temp = first;
        while(temp != null) {
            n++;
            temp = temp.next;
        }

        temp = second;
        while(temp != null) {
            m++;
            temp = temp.next;
        }

        Ll.Node head = new Ll.Node(-1);

        if(n==m) {

        } else if(n>m) {

        } {

        }

        return head;
    }

    public static void main(String[] args) {
        Ll.Node head1 = null, 
                head2 = null,
                a1 = new Ll.Node(3),
                a2 = new Ll.Node(4),
                a3 = new Ll.Node(5),
                common = new Ll.Node(15),
                a5 = new Ll.Node(30),

                b1 = new Ll.Node(4),
                b2 = new Ll.Node(5);
        
        head1 = a1;
        a1.next = a2;
        a2.next = a3;
        // a3.next = common;
        // common.next = a5;
        
        head2 = b1;
        b1.next = b2;
        // b2.next = common;

        // Ll.Node ans = addTwoLists_method2(head1, head2);
        // Ll ll = new Ll();
        // ll.head = ans;

        // Ll.println(ll);

        System.out.println(addTwoLists_method3(head1, head2));
    }    
}
