class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, vis, board, word, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int row, int col, int[][] vis, char[][] board, String word, int count) {
        int n = board.length;
        int m = board[0].length;
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        vis[row][col] = 1;
        
        if(count + 1 == word.length())
            return true;
        
        for(int i=0; i<4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            int ind = count + 1;
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0
              && board[nRow][nCol] == word.charAt(ind)){
                if(dfs(nRow, nCol, vis, board, word, ind))
                    return true;
            }
        }
        
        vis[row][col] = 0;
        return false;
    }
}