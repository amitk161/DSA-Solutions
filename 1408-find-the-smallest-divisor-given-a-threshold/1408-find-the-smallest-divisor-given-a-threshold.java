class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = getMax(nums);

        int lo = 1, hi = maxi;
        int ans = -1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(possible(nums, mid, threshold)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] nums, int div, int threshold){
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double) (nums[i]) / (double) (div));
        }
        
        if(sum > threshold) return false;
        return true;
    }

    private int getMax(int[] nums){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }
}