class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat .length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (isPossible(mat, i, j, n, m)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public boolean isPossible(int[][] mat, int i, int j, int n, int m){
        int up = (i > 0) ? mat[i - 1][j] : Integer.MIN_VALUE;
        int down = (i < n - 1) ? mat[i + 1][j] : Integer.MIN_VALUE;
        int left = (j > 0) ? mat[i][j - 1] : Integer.MIN_VALUE;
        int right = (j < m - 1) ? mat[i][j + 1] : Integer.MIN_VALUE;
        
        if(mat[i][j] > up && mat[i][j] > down && mat[i][j] > left && mat[i][j] > right) {
            return true;
        }
        return false;
    }
}