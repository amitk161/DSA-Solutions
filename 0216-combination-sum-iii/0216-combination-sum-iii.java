class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, 0, 0, k, n, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    
    private void findCombinations(int ind, int count, int s, int k, int sum, 
        List<Integer> ds, List<List<Integer>> ans){
        if(count == k){
            if(s == sum){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        for(int i=ind; i<=9; i++){
            if(count < k){
                ds.add(i);
                findCombinations(i+1, count+1, s + i, k, sum, ds, ans);
                ds.remove(ds.size() - 1);
            }
            //findCombinations(i+1, count, s, k, sum, ds, ans);
        }
    }
}