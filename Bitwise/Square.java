public class Square {

    /*
        if(n is even)
            n^2 = 4*square(n/2) 
        else 
            n^2 = 4*square(floor(n/2)) + 4*floor(n/2) + 1 

        and then do Recursion !!
    */

    static int square(int n) {
        if(n == 1) {
            return 1;
        }

        if((n&1)==0) {
            return (square((n>>1))<<2);         
        } else {
            return (square((n>>1))<<2) + ((n>>1)<<2) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(square(18));
    }    
}
