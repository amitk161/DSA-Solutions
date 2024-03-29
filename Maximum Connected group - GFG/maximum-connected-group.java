//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) continue;
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                for(int ind=0; ind<4; ind++){
                    int nrow = i + dr[ind];
                    int ncol = j + dc[ind];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                        int nodeNo = i * n + j;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        
        int mx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                for(int ind=0; ind<4; ind++){
                    int nrow = i + dr[ind];
                    int ncol = j + dc[ind];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                        set.add(ds.findUPar(nrow * n + ncol));
                    }
                }
                int sizeTotal = 0;
                for(Integer it: set){
                    sizeTotal += ds.size.get(it);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        
        for(int cell=0; cell<n * n; cell++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cell)));
        }
        return mx;
    }
    
    private boolean isValid(int nrow, int ncol, int n){
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < n;
    }
}