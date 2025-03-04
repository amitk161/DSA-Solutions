class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }

        suffix[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }

        int water = 0;
        for(int i=0; i<arr.length; i++){
            water += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return water;
    }
}