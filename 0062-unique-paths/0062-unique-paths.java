class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }    

        return count(0, 0, m, n, dp);
    }

    private int count(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1)
            return 1;

        if(i >= m || j >= n)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];    

        dp[i][j] = count(i, j+1, m, n, dp) + count(i+1, j, m, n, dp);        

        return dp[i][j];
    }
}