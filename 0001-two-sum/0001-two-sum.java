class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int p = 0, q = 0;
        int[] res = new int[2];
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] == target){
                    p = i;
                    q = j;
                    break;
                }
            }
        }
        
        res[0] = p;
        res[1] = q;
        return res;
    }
}