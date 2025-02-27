class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int maxi = Integer.MIN_VALUE;
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            maxi = Math.max(maxi, r-l+1);
            map.put(s.charAt(r), r);
            r++;
        }
        return maxi;
    }
}