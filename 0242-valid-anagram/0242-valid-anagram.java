class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0; i<t.length(); i++){
            char ch1 = t.charAt(i);
            map2.put(ch1, map2.getOrDefault(ch1, 0) + 1);
        }
        
        return map1.equals(map2);
    }
}