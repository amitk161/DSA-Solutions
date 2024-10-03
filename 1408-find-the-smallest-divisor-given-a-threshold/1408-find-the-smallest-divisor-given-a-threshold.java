class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = getMax(nums);
        int ans = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(isPossible(nums, mid, threshold)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int ele, int threshold){
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)(nums[i]) / (double)(ele));
        }

        if(sum <= threshold) return true;
        return false;
    }

    public int getMax(int[] nums){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }
}