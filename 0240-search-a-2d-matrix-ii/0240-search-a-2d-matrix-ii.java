class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for(int i=0; i<n; i++){
            boolean search = bs(matrix[i], target);
            if(search)
                return true;
        }
        return false;
    }

    private boolean bs(int[] arr, int target){
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;        
        }
        return false;
    }
}