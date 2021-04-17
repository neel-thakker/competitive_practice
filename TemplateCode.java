import java.util.*;
import java.io.*;

public class TemplateCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim()), ans = 0;
        
            log.write(ans+"\n");
        }   // end-while

        br.close();
        log.flush();
    }   // end-main

    static void print(int arr[]) {
        System.out.print("Print :- ");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }   // end-print
}   // end-class
