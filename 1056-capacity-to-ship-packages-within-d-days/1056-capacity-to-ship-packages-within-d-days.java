class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = getMax(weights);
        int hi = getSum(weights);
        int ans = 0;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(getDays(weights, mid) <= days){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public int getDays(int[] weights, int cap){
        int minDay = 1, sum = 0;

        for(int i=0; i<weights.length; i++){
            if(sum + weights[i] <= cap){
                sum += weights[i];
            } else {
                sum = weights[i];
                minDay++;
            }
        }
        return minDay;
    }

    private int getMax(int[] weights){
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
        }
        return maxi;
    }

    private int getSum(int[] weights){
        int sum = 0;

        for(int i=0; i<weights.length; i++){
            sum += weights[i];
        }
        return sum;
    }
}