class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m * k) return -1;

        int mini = findMini(bloomDay);
        int maxi = findMaxi(bloomDay);

        int lo = mini, hi = maxi;
        int ans = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            boolean poss = possible(bloomDay, mid, m, k);
            
            if(poss){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            } 
        }
        return ans;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k){
        int cnt = 0, bouquet = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                cnt++;
            } else {
                bouquet += cnt / k;
                cnt = 0;
            }
        }
        bouquet += cnt / k;
        
        if(bouquet >= m) return true;
        return false;
    }

    public int findMini(int[] arr){
        int mini = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++){
            mini = Math.min(mini, arr[i]);
        }
        return mini;
    }

    public int findMaxi(int[] arr){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }
}