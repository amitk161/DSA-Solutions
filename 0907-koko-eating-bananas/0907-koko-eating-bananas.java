class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = getMax(piles);

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int totalHours = getHours(piles, mid);

            if(totalHours <= h)
                hi = mid - 1;
            else
                lo = mid + 1;    
        }
        return lo;
    }

    public int getHours(int[] piles, int hours){
        int ans = 0;
        for(int i=0; i<piles.length; i++){
            ans += Math.ceil((double)(piles[i]) / (double)(hours)); 
        }
        return ans;
    }

    public int getMax(int[] piles){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }
}