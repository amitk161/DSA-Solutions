class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() > Math.floor(n/3)){
                list.add(it.getKey());
            }
        }
        return list;
    }
}