class Solution {
    public int splitArray(int[] nums, int k) {
        int lo = -1, hi = 0;
        for(int i=0; i<nums.length; i++){
            lo = Math.min(lo, nums[i]);
            hi += nums[i];
        }
        
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(isPossible(nums, mid, k)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean isPossible(int[] nums, int mid, int k){
        int cnt = 1, sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > mid) return false;
            
            if(sum + nums[i] > mid){
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        if(cnt > k) return false;
        return true;
    }
}