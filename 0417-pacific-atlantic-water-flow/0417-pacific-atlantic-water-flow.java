class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return res;

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<n; i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific, delrow, delcol);
            dfs(heights, i, m-1, Integer.MIN_VALUE, atlantic, delrow, delcol);
        } 

        for(int i=0; i<m; i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific, delrow, delcol);
            dfs(heights, n-1, i, Integer.MIN_VALUE, atlantic, delrow, delcol);
        }    

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, int prev, boolean[][] ocean, int[] delrow, int[] delcol){
        ocean[row][col] = true;
        int n = heights.length;
        int m = heights[0].length;

        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && heights[nrow][ncol] >= heights[row][col] && !ocean[nrow][ncol]){
                dfs(heights, nrow, ncol, heights[nrow][ncol], ocean, delrow, delcol);
            }
        }    
    }
}