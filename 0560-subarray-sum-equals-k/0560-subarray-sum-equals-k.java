class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, cnt = 0;
        map.put(0, 1);
        
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            
            int remove = prefixSum - k;
            cnt += map.getOrDefault(remove, 0);
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }
}