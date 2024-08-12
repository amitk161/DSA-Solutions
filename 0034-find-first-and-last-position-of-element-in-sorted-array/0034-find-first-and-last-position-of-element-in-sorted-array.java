class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerbound(nums, target);
        if(first == nums.length || nums[first] != target)
            return new int[] {-1, -1};
        int last = upperbound(nums, target) - 1;

        return new int[] {first, last};    
    }

    public int lowerbound(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        int ans = nums.length;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(nums[mid] >= target){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public int upperbound(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        int ans = nums.length;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(nums[mid] > target){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}