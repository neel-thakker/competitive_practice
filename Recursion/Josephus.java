import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {

    static void solve(ArrayList<Integer> arr, int k, int curr) {
        if (arr.size() == 1) {
            System.out.println(arr.get(0));
            return;
        }

        int index = (curr + k) % arr.size();
        arr.remove(index);

        if (index == arr.size())
            index = 0;

        solve(arr, k, index);
    } // end-method

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(), k = kb.nextInt() - 1;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        solve(arr, k, 0);

        kb.close();
    } // end-main
} // end-class
