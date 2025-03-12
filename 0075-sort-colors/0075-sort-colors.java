class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = 0;

        while(index <= end){
            if(nums[index] == 0){
                swap(nums, index, start);
                start++;
                index++;
            } else if(nums[index] == 1){
                index++;
            } else {
                swap(nums, index, end);
                end--;
            }
        }
    }

    public void swap(int[] nums, int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
}