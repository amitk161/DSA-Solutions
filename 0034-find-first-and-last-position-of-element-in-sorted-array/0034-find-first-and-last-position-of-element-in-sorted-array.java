class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = getFirst(nums, target);
        if(first == -1)
            return new int[] {-1, -1};

        int last = getLast(nums, target);

        return new int[] {first, last};
    }

    public int getFirst(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        int first = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(nums[mid] == target){
                first = mid;
                hi = mid - 1;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return first;
    }

    public int getLast(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        int last = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(nums[mid] == target){
                last = mid;
                lo = mid + 1;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return last;
    }
}