import java.util.*;

class Meeting {
    int start, end;
    Meeting(int a, int b) {
        this.start = a;
        this.end = b;
    }
}

public class NmeetingsInOneRoom {

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        Meeting arr[] = new Meeting[n];
        
        for(int i=0 ; i<n ; i++) {
            arr[i] = new Meeting(start[i], end[i]);
        }
        
        Arrays.sort(arr, new Comparator<Meeting>() {
            public int compare(Meeting x, Meeting y) {
                return x.start - y.start;
            }
        });
        
        // for(int i=0 ; i<n ; i++) {
        //     System.out.println(arr[i].start + " " + arr[i].end);
        // }
        
        int endTime = 0, ans = 0;
        for(int i=0 ; i<n ; i++) {
            
            if( (arr[i].start < endTime) && ( arr[i].end < endTime) ) {
                endTime = arr[i].end;
            } else if(arr[i].start > endTime) {
                endTime = arr[i].end;
                ans++;
            }
            
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        System.out.println(maxMeetings(start, end, n));
    }   
}