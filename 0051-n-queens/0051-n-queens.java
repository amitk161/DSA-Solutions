class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2*n-1];
        int[] lowerDiag = new int[2*n-1];
        
        solve(0, board, ans, leftRow, upperDiag, lowerDiag);
        return ans;
    }
    
    private void solve(int col, char[][] board, List<List<String>> ans, int[] leftRow,
                      int[] upperDiag, int[] lowerDiag){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int i=0; i<board.length; i++){
            if(leftRow[i] == 0 && upperDiag[i+col] == 0 && lowerDiag[board.length-1+col-i] == 0){
                board[i][col] = 'Q';
                leftRow[i] = 1;
                upperDiag[i+col] = 1;
                lowerDiag[board.length-1+col-i] = 1;
                
                solve(col+1, board, ans, leftRow, upperDiag, lowerDiag);
                
                board[i][col] = '.';
                leftRow[i] = 0;
                upperDiag[i+col] = 0;
                lowerDiag[board.length-1+col-i] = 0;
            }
        }
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