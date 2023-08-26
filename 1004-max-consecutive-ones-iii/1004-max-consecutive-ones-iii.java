class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, ans = 0, zero = 0;
    int n = nums.length;

    while (j < n) {
        if (nums[j] == 0) {
            zero++;

            while (zero > k) {
                if (nums[i] == 0) {
                    zero--;
                }
                i++;
            }
        }

        ans = Math.max(ans, j - i + 1);
        j++; // Increment j here
    }
    
    return ans;
    }
}