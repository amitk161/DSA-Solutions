class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);    
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int ind = map.get(val);
        map.remove(val);

        if(ind == list.size() - 1){
            list.remove(list.size() - 1);
            return true;
        }
            
        list.set(ind, list.get(list.size() - 1));    
        list.remove(list.size() - 1);
        map.put(list.get(ind), ind);
        return true;
    }
    
    public int getRandom() {
        int randomidx = r.nextInt(list.size());
        return list.get(randomidx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */