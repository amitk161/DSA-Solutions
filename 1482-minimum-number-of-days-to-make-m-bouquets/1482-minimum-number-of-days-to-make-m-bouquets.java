class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int lo = 0, hi = Integer.MAX_VALUE - 1;
        int ans = -1;
        
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
    
    private boolean check(int[] arr, int mid, int m, int k){
        int tot = 0, c = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid){
                c++;
                
                if(c == k){
                    tot++;
                    c = 0;
                }
            } else 
                c = 0;
        }
        
        if(tot >= m) return true;
        return false;
    }
}