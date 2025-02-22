class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0, candidate = 0;

        for(int i=0; i<n; i++){
            if(cnt == 0){
                candidate = nums[i];
                cnt++;
            }

            else if(nums[i] == candidate)
                cnt++;
            else
                cnt--;    
        }
        return candidate;
    }
}