class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int maxf = 0;
            for(int j=i; j<s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                maxf = Math.max(maxf, map.get(s.charAt(j)));
                int changes = j-i+1 - maxf;

                if(changes <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
}