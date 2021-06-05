public class CopySetBitsInRange {
    public static void main(String[] args) {

        // x = 101100, y = 11;
        int x = 44, y = 3, l = 1, r = 5;

        for(int i=l-1 ; i<r ; i++) {
            if( ((y&(1<<i))>0) && ((x&(1<<i))==0) ) {
                x = (x|(1<<i));
            }
        }
        
        System.out.println(x);  //101111
    }    
}
