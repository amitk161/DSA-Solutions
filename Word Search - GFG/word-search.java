//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        int n = board.length;
        int m = board[0].length;
        
        int[][] vis = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, board, word, vis, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int row, int col, char[][] board, String word, int[][] vis, int count){
        int n = board.length;
        int m = board[0].length;
        
        if(count + 1 == word.length())
            return true;
        
        vis[row][col] = 1;
        int[] di = {-1 ,0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        
        for(int i=0; i<4; i++){
            int nrow = row + di[i];
            int ncol = col + dj[i];
            int ind = count + 1;
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
            && board[nrow][ncol] == word.charAt(ind)){
                if(dfs(nrow, ncol, board, word, vis, ind))
                    return true;
            }
        }
        
        vis[row][col] = 0;
        return false;
    }
}