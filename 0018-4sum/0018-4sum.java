class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){
                for(int j=i+1; j<n; j++){
                    if(j == i + 1 || j > i+1 && nums[j] != nums[j-1]){
                        int lo = j+1, hi = n-1;
                        
                        while(lo < hi){
                            long sum = nums[i] + nums[j];
                            sum += nums[lo];
                            sum += nums[hi];
                            
                            if(sum == target){
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[lo]);
                                list.add(nums[hi]);
                                ans.add(list);
                                
                                while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                                while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                                lo++;
                                hi--;
                                
                            } else if(sum < target)
                                lo++;
                             else
                                hi--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}