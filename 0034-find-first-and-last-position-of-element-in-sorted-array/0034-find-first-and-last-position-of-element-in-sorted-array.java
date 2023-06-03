class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int first = getFirst(nums, target);
        int last = getLast(nums, target);
        
        res[0] = first;
        res[1] = last;
        return res;
    }
    
    private int getFirst(int[] arr, int target){
        int lo = 0, hi = arr.length-1;
        int first = -1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] == target){
                first = mid;
                hi = mid - 1;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return first;
    }
    
    private int getLast(int[] arr, int target){
        int lo = 0, hi = arr.length - 1;
        int last = -1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] == target){
                last = mid;
                lo = mid + 1;
            } else if(arr[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return last;
    }
}