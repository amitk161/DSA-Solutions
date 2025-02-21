class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0, cnt = 0, minLen = Integer.MAX_VALUE, sIndex = -1;

        while(r < m){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0)
                cnt++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while(cnt == n){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }

                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                if(map.containsKey(s.charAt(l)) && map.get(s.charAt(l)) > 0)
                    cnt--;
                l++;    
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

}