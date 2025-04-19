class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}