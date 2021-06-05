public class FindOnlySetBitPosition {

    /*
        Ek hi bit set hai matlab hai koi 2 ki power hai!!!!!
        some no. x is a power of 2 only when ( x&(x-1) )==0

        therefore ans = log2(n) + 1;            #oneLiner
    */

    static int findPosition(int n) {
        if((n&(n-1))>0 || n==0) 
            return -1;
        
        return ((int) (Math.log(n)/Math.log(2))) + 1;
    }

    public static void main(String[] args) {
        System.out.println(findPosition(8));
    }
}