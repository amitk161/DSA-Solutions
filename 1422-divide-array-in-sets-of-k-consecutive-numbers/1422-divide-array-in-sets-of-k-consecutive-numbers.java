class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);    

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }    

        for(int current: hand){
            if(!map.containsKey(current))
                continue; 

            for(int i=0; i<groupSize; i++){
                int card = current + i;
                if(!map.containsKey(card))
                    return false;

                map.put(card, map.get(card) - 1);    
                if(map.get(card) == 0)
                    map.remove(card);    
            }
        }
        return true;
    }
}