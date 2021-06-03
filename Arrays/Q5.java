public class Q5 {

    /*
        Move all the Negative elements to the beginning of the array with constant extra space. 
    */

    static void move(int arr[]) {
        int n = arr.length, j = 0;
         
        for(int i=0 ; i<n ; i++) {
            if(arr[i]<0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    static void print(int arr[]) {
        int n = arr.length;
        for(int i=0 ; i<n ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };

        move(arr);
        print(arr);
    }    
}
