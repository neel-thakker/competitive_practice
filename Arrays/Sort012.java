import java.util.*;

public class Sort012 {

    public static void sort012(int arr[], int n) {
        int zeros=0, ones=0, twos=0;
        for(int i=0 ; i<n ; i++) {
            if(arr[i]==0) {
                zeros++;
            } else if(arr[i]==1) {
                ones++;
            } else if(arr[i]==2) {
                twos++;
            }
        }
        
        for(int i=0 ; i<n ; i++) {
            if(i<zeros) {
                arr[i] = 0;
                continue;
            }
            
            if((i-zeros)<ones) {
                arr[i] = 1;
                continue;
            }
            
            arr[i] = 2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), arr[] = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }        

        sort012(arr, n);
        print(arr, n);
    }

    public static void print(int arr[], int n) {
        System.out.print("["+arr[0]);
        for(int i=1 ; i<n ; i++) {
            System.out.print(", "+arr[i]);
        }
        System.out.println("]");
    }
}
