class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = -1, hi = 0;
        
        for(int i=0; i<weights.length; i++){
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }
        
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(check(weights, mid, days)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(int[] weights, int mid, int days){
        int sum = 0, cnt = 1;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            if(sum > mid){
                cnt++;
                sum = weights[i];
            }
        }
        
        if(cnt <= days) return true;
        return false;
    }
}