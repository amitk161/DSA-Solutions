class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int closestSum = -1;
    
        for(int i=0; i<n; i++){
            int lo = i+1, hi = n-1;
            
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if(sum < target){
                    lo++;
                    
                    int diff = Math.abs(target - sum);
                    if(diff < minDiff){
                        minDiff = diff;
                        closestSum = sum;
                    }
                } else if(sum > target){
                    hi--;
                    
                    int diff = Math.abs(target - sum);
                    if(diff < minDiff){
                        minDiff = diff;
                        closestSum = sum;
                    }
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}