class Pair{
    int element;
    int frequency;

    public Pair(int element, int frequency){
        this.element = element;
        this.frequency = frequency;
    }    
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.frequency - x.frequency);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        int ind = 0;

        while(k > 0){
            Pair it = pq.poll();
            res[ind++] = it.element;
            k--;
        }
        return res;
    }
}