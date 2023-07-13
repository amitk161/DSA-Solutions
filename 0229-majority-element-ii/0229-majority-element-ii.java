class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = -1, el2 = -1, cnt1 = 0, cnt2 = 0;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] == el1){
                cnt1++;
            } else if(nums[i] == el2){
                cnt2++;
            } else if(cnt1 == 0){
                el1 = nums[i];
                cnt1 = 1;
            } else if(cnt2 == 0){
                el2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] == el1){
                cnt1++;
            } else if(nums[i] == el2){
                cnt2++;
            }
        }
        
        if(cnt1 > n/3){
            ans.add(el1);
        }
        
        if(cnt2 > n/3){
            ans.add(el2);
        }
        
        return ans;
    }
}