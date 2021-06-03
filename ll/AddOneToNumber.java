public class AddOneToNumber {

    static Ll.Node addOne(Ll.Node head) {
        Ll.Node temp = head;
        boolean isNine = false, allNine = true;
        int n = 0;

        while(temp!=null) {

            if(temp.data!=9) {
                allNine = false;
            }

            if(temp.next==null) {
                if(temp.data==9) {
                    temp.data = 0;
                    isNine = true;
                } else {
                    temp.data = temp.data + 1; 
                }
            }

            n++;
            temp = temp.next;
        }

        for(int i=n-1 ; i>=0 ; i--) {
            if(!isNine)
                break;

            int p=0;
            temp = head;
            while(p<i-1){
                temp = temp.next;
                p++;
            }

            if(temp.data==9) {
                temp.data = 0;
            } else {
                temp.data = temp.data + 1;
                isNine = false;
            }
        }   // end-for

        if(allNine) {
            temp = new Ll.Node(1);
            temp.next = head;
            head.data = 0;
            head = temp;
        }
        
        return head;
    }

    public static void main(String[] args) {
        Ll ll = new Ll();

        Ll.add(ll, 9);
        Ll.add(ll, 9);
        Ll.add(ll, 9);
        Ll.add(ll, 9);
        Ll.add(ll, 9);

        ll.head = addOne(ll.head);       

        Ll.println(ll);
    }    
}
