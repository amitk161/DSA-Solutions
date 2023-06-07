class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
       if(n == 1)
            return 0;
       
       while(lo <= hi){
           int mid = (lo + (hi-lo) / 2);
           
           if(mid > 0 && mid < n - 1){
                if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                else if(arr[mid - 1] > arr[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
           } else if(mid == 0){
               if(arr[0] > arr[1]) 
                    return 0;
                else 
                    return 1;
           } else if(mid == n-1){
                if(arr[n-1] > arr[n-2])
                    return n-1;
                else 
                    return n-2;
           }
       }
       return -1;
    }
}