class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(nums[i] + nums[j]);
                if(hs.contains(third)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    set.add(list);
                }
                hs.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}