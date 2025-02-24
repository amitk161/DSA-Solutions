class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    private void dfs(int row, int col, int[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                dfs(nrow, ncol, vis, grid);
            }
        }
    }
}