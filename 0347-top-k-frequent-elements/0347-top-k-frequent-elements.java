class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ind = 0;
        int[] res = new int[k];

        while(k > 0){
            int maxFreq = 0;
            int ele = 0;

            for(int it: map.keySet()){
                if(map.get(it) > maxFreq){
                    maxFreq = map.get(it);
                    ele = it;
                }
            }

            res[ind++] = ele;
            map.remove(ele);
            k--;
        }
        return res;
    }
}