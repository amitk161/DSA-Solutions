class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = -1, el2 = -1, c1 = 0, c2 = 0;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] == el1){
                c1++;
            } else if(nums[i] == el2){
                c2++;
            } else if(c1 == 0){
                el1 = nums[i];
                c1 = 1;
            } else if(c2 == 0){
                el2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        c1 = 0; c2 = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] == el1){
                c1++;
            } else if(nums[i] == el2){
                c2++;
            }
        }
        
        if(c1 > n/3){
            list.add(el1);
        }
        
        if(c2 > n/3){
            list.add(el2);
        }
        
        return list;
    }
}