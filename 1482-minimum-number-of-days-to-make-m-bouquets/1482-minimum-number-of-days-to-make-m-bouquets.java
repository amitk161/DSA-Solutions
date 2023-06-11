class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int lo = 0, hi = 0;
        int ans = -1;
        
        for(int i=0; i<bloomDay.length; i++){
            lo = Math.min(lo, bloomDay[i]);
            hi = Math.max(hi, bloomDay[i]);
        }
        
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(check(bloomDay, mid, m, k)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(int[] arr, int mid, int m, int flowers){
        int bouquetCount = 0, adj = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid){
                adj++;
                
                if(adj == flowers){
                    bouquetCount++;
                    adj = 0;
                }
            } else 
                adj = 0;
        }
        
        if(bouquetCount >= m) return true;
        return false;
    }
}