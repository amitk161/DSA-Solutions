class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele: arr){
            set.add(ele);
        }

        int rank = 1;
        for(int num: set){
            map.put(num, rank);
            rank++;
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}