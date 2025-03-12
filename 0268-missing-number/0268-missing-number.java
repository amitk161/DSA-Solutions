class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int[] hash = new int[n+1];

        for(int i=0; i<n-1; i++){
            hash[nums[i]] = 1;
        }

        for(int i=0; i<=n; i++){
            if(hash[i] != 1)
                return i;
        }
        return -1;
    }
}