class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int num = 1;
        
        while(i < n && k > 0){
            if(arr[i] == num){
                i++;
            } else {
                k--;
            }
            num++;
        }
        
        while(k > 0){
            num++;
            k--;
        }
        return num-1;
    }
}