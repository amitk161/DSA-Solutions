class Solution {
    public int splitArray(int[] nums, int k) {
        if(k > nums.length)
            return -1;

        int maxi = Integer.MIN_VALUE, sum = 0;

        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            sum += nums[i];
        }    

        int lo = maxi, hi = sum;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int cnt = getAnswer(nums, mid);

            if(cnt > k)
                lo = mid + 1;
            else
                hi = mid - 1;    
        }
        return lo;
    }

    private int getAnswer(int[] nums, int mid){
        int part = 1, elements = 0;

        for(int i=0; i<nums.length; i++){
            if(elements + nums[i] <= mid){
                elements += nums[i];
            } else {
                part++;
                elements = nums[i];
            }
        }
        return part;
    }
}