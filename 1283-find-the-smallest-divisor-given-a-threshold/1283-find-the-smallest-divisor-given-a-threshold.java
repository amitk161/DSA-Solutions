class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0;
        
        for(int i=0; i<nums.length; i++){
            hi = Math.max(hi, nums[i]);
        }
        
        int ans = -1;
        
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(check(nums, mid, threshold)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(int[] nums, int mid, int threshold){
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            //double res = nums[i] / mid;
            // System.out.println("ele is " + nums[i]);
            // System.out.println("res is " + res);
            //int div = (int) Math.ceil(res);
            //System.out.println("div is " + div);
            sum += Math.ceil((double) nums[i] / mid);
        }
        //System.out.println("Sum is " + sum + " mid is " + mid);
        if(sum <= threshold) return true;
        return false;
    }
}