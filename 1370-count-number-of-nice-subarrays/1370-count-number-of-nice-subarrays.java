class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getAnswer(nums, k) - getAnswer(nums, k-1);
    }

    private int getAnswer(int[] nums, int k){
        if(k < 0) return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;

        while(r < nums.length){
            sum += nums[r] % 2;

            while(sum > k){
                sum -= nums[l] % 2;
                l++;
            }

            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}