class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int max = -1;
        int[] res = new int[2];
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] > max){
                    max = mat[i][j];
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}