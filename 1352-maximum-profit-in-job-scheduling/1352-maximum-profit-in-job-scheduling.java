class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for(int i=0; i<n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        return solve(arr, 0, dp);
    }

    private int solve(int[][] arr, int i, int[] dp){
        int n = arr.length;

        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int next = getNextIndex(arr, i+1, arr[i][1]);

        int taken = arr[i][2] + solve(arr, next, dp);
        int notTaken = 0 + solve(arr, i+1, dp);    

        return dp[i] = Math.max(taken, notTaken);
    }

    private int getNextIndex(int[][] arr, int l, int currentJobEnd){
        int n = arr.length;
        int r = n -1;
        int result = n + 1;

        while(l <= r){
            int mid = (l+r) / 2;
            if(arr[mid][0] >= currentJobEnd){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}