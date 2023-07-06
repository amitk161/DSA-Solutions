class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int longestStreak = 0;
        for(int num: nums){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                
                while(set.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }
              longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}