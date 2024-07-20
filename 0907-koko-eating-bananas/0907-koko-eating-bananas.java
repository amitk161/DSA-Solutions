class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while(low <= high){
            int mid = (low + high) / 2;
            int totalHours = calculateAnswer(piles, mid);

            if(totalHours <= h)
                high = mid - 1;
            else 
                low = mid + 1;    
        }
        return low;
    }

    public int findMax(int[] piles){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public int calculateAnswer(int[] piles, int hours){
        int total = 0;

        for(int i=0; i<piles.length; i++){
            total += Math.ceil((double)(piles[i]) / (double)(hours));
        }
        return total;
    }

}