class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int lo = 0, hi = m - 1;
        
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            int maxRow = 0;
            
            for(int i=0; i<n; i++){
                if(mat[maxRow][mid] < mat[i][mid]){
                    maxRow = i;
                }
            }
            
            if((mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]) && 
              (mid == m-1 || mat[maxRow][mid] > mat[maxRow][mid + 1])){
                return new int[] {maxRow, mid};
            } else if(mid > 0 && mat[maxRow][mid] < mat[maxRow][mid - 1])
                hi = mid - 1;
            else
                lo = mid + 1;

        }
        return new int[] {-1, -1};
    }
}