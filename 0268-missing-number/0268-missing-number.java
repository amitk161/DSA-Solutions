class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length + 1;

        for(int i=0; i<=n; i++){
            int flag = 0;
            for(int j=0; j<n-1; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0)
                return i;
        }
        return 0;
    }
}