class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

        for(String s: strs){
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                fmap.put(s.charAt(i), fmap.getOrDefault(s.charAt(i), 0) + 1);
            }

            if(!bmap.containsKey(fmap)){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                bmap.put(fmap, list);
            } else {
                ArrayList<String> list = bmap.get(fmap);
                list.add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> val: bmap.values()){
            res.add(val);
        }
        return res;
    }
}