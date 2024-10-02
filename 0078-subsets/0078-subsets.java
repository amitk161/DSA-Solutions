class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        countSubsets(0, ds, nums, nums.length, ans);
        return ans;
    }

    public void countSubsets(int ind, List<Integer> ds, int[] nums, int n, List<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        countSubsets(ind+1, ds, nums, n, ans);
        ds.remove(ds.size() - 1);
        countSubsets(ind+1, ds, nums, n, ans);
    }
}