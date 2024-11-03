class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxf = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;

        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));

            if(r-l+1 - maxf > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                maxf = 0;  
                l++;
            }

            if(r-l+1 - maxf <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        
        return maxLen;
    }
}