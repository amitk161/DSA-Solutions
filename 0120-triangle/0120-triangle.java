class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        } 
        
        return f(0, 0, n, triangle, dp);
    }
    
    private int f(int i, int j, int n, List<List<Integer>> triangle, int[][] dp){
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int d = triangle.get(i).get(j) + f(i+1, j, n, triangle, dp);
        int dg = triangle.get(i).get(j) + f(i+1, j+1, n, triangle, dp);
        
        return dp[i][j] = Math.min(d, dg);
    }
}