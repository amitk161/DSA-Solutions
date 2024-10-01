class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> mapElement: map.entrySet()){
            if(mapElement.getValue() > n/2)
                return mapElement.getKey();
        }
        return -1;
    }
}