class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int len = 0;

        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            map.put(s.charAt(r), r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}