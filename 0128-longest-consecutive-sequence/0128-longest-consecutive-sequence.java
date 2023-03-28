class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        
        int ans = 1, prev = nums[0], cur = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == prev+1){
                cur++;
            } else if(nums[i] != prev){
                cur = 1;
            }
            
            prev = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}