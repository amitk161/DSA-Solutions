//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Tuple
{
    int first;
    int second;
    int third;
    
    public Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> (x.first - y.first));
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            Tuple it = pq.peek();
            int dis = it.first;
            int r = it.second;
            int c = it.third;
            pq.remove();
            
            if(r == n-1 && c == m-1)
                return dis;
            
            for(int i=0; i<4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                
                if(nrow >= 0 && nrow< n && ncol >= 0 && ncol < m){
                    int newEfforts = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]), dis);
                    if(newEfforts < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEfforts;
                        pq.add(new Tuple(dist[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}