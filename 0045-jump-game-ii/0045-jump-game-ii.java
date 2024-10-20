class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, currEnd = 0, furthest = 0;
        
        for (int i = 0; i < n - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            
            if (i == currEnd) {
                jumps++;           
                currEnd = furthest;
            }
        }
        return jumps;
    }
}