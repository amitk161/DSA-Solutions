class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
    
    private void find(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            find(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        find(ind+1, arr, target, ans, ds);
    }
}