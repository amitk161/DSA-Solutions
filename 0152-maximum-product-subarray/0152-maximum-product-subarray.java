class Solution {
    public int maxProduct(int[] nums) {
        int min = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int prod = 1;
            for(int j=i; j<n; j++){
                prod *= nums[j];
                min = Math.max(min, prod);
            }
        }
        return min;
    }
}