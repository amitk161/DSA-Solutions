class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxDistance = 0;
        for(int[] trip: trips){
            maxDistance = Math.max(maxDistance, trip[2]);
        }

        int[] passengers = new int[maxDistance + 1];
        
        for(int[] trip: trips){
            int pass = trip[0];
            int from = trip[1];
            int to = trip[2];

            passengers[from] += pass;
            passengers[to] -= pass;
        }

        int currentPass = 0;
        for(int temp: passengers){
            currentPass += temp;

            if(currentPass > capacity)
                return false;
        }
        return true;
    }
}