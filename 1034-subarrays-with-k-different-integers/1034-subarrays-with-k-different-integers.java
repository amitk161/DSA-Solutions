class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getAnswer(nums, k) - getAnswer(nums, k-1);
    }

    private int getAnswer(int[] nums, int k){
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;    
            }

            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}