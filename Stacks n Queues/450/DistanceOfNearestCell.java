import java.util.*;

public class DistanceOfNearestCell {
    
    /*
        Given a binary grid. Find the distance of nearest 1 in the grid for each cell.
        The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number and column number of the current 
        cell and i2, j2 are the row number and column number of the nearest cell having value 1.
    */

    static boolean isSafe(int[][] arr, int n, int m, int i, int j) {
        return i>=0 && i<n && j>=0 && j<m && arr[i][j]==Integer.MAX_VALUE;
    }
        
    static int[][] method1(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++) 
                ans[i][j] = Integer.MAX_VALUE;

        Queue<Pair> q = new LinkedList<>();
        for(int i=0 ; i<n ; i++) 
            for(int j=0 ; j<m ; j++)
                if(arr[i][j] == 1)
                    q.add(new Pair(i, j));
        
        int addx[] = {1, -1, 0, 0}, addy[] = {0, 0, 1, -1};
        int dist = 0;
        while(!q.isEmpty()) {
            int k = q.size();

            for(int i=0 ; i<k ; i++) {
                Pair temp = q.remove();
                ans[temp.i][temp.j] = Math.min(dist, ans[temp.i][temp.j]);      // most imp line, dono mai se minimum diya ussko...

                for(int j=0 ; j<4 ; j++) {
                    int x = temp.i + addx[j], y = temp.j + addy[j];
                    if(isSafe(arr, n, m, x, y)) {
                        q.add(new Pair(x, y));
                    }
                }
            }

            dist++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 0, 0 },
            { 0, 0, 1, 1 }
        };

        int ans[][] = method1(arr);
        for(int i=0 ; i<ans.length ; i++) {
            for(int j=0 ; j<ans[0].length ; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}
