class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        dfs(0, n, board, ans);
        return ans;
    }
    
    private void dfs(int col, int n, char[][] board, List<List<String>> ans){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        
        for(int i=0; i<n; i++){
            if(validate(board, i, col)){
                board[i][col] = 'Q';
                dfs(col+1, n, board, ans);
                board[i][col] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int row, int col){
        int duprow = row;
        int dupcol = col;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    
    private List<String> construct(char[][] board){
        List<String> list = new LinkedList<>();
        
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
}