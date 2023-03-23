class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        int dup = -1;
        
        for(int i=0; i<nums.length; i++){
            if(arr[nums[i]] == 0){
                arr[nums[i]] = 1;
            } else {
                dup = nums[i];
            }
        }
        return dup;
    }
}