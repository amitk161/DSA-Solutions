class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recur(nums, freq, new ArrayList<>(), ans);
        return ans;
    }
    
    private void recur(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(freq[i] == false){
                freq[i] = true;
                ds.add(nums[i]);
                recur(nums, freq, ds, ans);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}