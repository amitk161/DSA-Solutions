class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int maxi = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int l = 0;

        for(int r=0; r<s.length(); r++){
            if(set.contains(s.charAt(r))){
                while(l < r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }   
            }

            maxi = Math.max(maxi, r-l+1);
            set.add(s.charAt(r));
        }   
        return maxi; 
    }
}