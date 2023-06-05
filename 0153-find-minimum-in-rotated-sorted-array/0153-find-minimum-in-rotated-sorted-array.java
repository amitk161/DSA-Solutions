class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int k = Integer.MAX_VALUE;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(nums[lo] <= nums[mid]){
                if(nums[lo] < k){
                    k = nums[lo];
                }
                lo = mid + 1;
            } else {
                if(nums[mid] < k){
                    k = nums[mid];
                }
                hi = mid - 1;
            }
        }
        return k;
    }
}