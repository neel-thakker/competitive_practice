import java.util.*;

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class RottenOranges {

    // #Recursion
    static int findMinDistance(int[][] arr, int n, int m, int i, int j) {
        if(i<0 || i>=n || j<0 || j>=m)
            return 100000000;
        
        if(arr[i][j]==0)
            return 100000000;
            
        if(arr[i][j]==2)
            return 0;
            
        int a = 1 + findMinDistance(arr, n, m, i+1, j);
        int b = 1 + findMinDistance(arr, n, m, i-1, j);
        int c = 1 + findMinDistance(arr, n, m, i, j+1);
        int d = 1 + findMinDistance(arr, n, m, i, j-1);
    
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
    
    // This will not run properly, coz space complexity shouuld be O(1)
    static int method1(int[][] arr) {
        int ans = Integer.MIN_VALUE, n = arr.length, m = arr[0].length;
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(arr[i][j]==1) {
                    int a = findMinDistance(arr, n, m, i, j);
                    if(a>ans)
                        ans = a;
                }
            }
        }
        
        return ans;
    }
    
    static boolean isSafe(int[][] arr, int n, int m, int i, int j) {
        return i>=0 && i<n && j>=0 && j<m && arr[i][j]==1;
    }
    
    // #Efficient
    static int method2(int[][] arr) {
        int ans = 0, n = arr.length, m = arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++) 
                if(arr[i][j]==2)
                    q.add(new Pair(i,j));
             
        int addx[] = {1, -1, 0, 0}, addy[] = {0, 0, 1, -1};
                    
        while(!q.isEmpty()) {
            int size = q.size();
            boolean isDone = true;
            
            for(int i=0 ; i<size ; i++) {
                Pair p = q.poll();
                
                for(int j=0 ; j<4 ; j++) {
                    if(isSafe(arr, n, m, p.i + addx[j], p.j + addy[j])) {
                        if(isDone) {
                            ans++;                                  // Very imp note why we did keep this here!!!!!
                            isDone = false;
                        }
            
                        arr[ p.i + addx[j] ][ p.j + addy[j] ] = 2;
                        q.add(new Pair(p.i + addx[j], p.j + addy[j]));
                    }
                }
            }
        }
        
        for(int i=0 ; i<n ; i++) 
            for(int j=0 ; j<m ; j++)
                if(arr[i][j]==1)
                    return -1;
        
        return ans;   
    }

    public static void main(String[] args) {
        int arr[][] = {
            { 0, 1, 2 },
            { 0, 1, 2 },
            { 2, 1, 1 }
        };

        System.out.println(method2(arr));
    }
}