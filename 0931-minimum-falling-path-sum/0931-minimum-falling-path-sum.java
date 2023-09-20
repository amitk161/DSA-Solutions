class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                
                int up = matrix[i][j] + dp[i-1][j];
                
                int ld = matrix[i][j];
                if(j-1 >= 0)
                    ld += dp[i-1][j-1];
                else
                    ld += (int) Math.pow(10, 9);
                
                int rd = matrix[i][j];
                if(j+1 < m)
                    rd += dp[i-1][j+1];
                else
                    rd += (int) Math.pow(10, 9);
                
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int j=0; j<m; j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        
        return mini;
    }
}