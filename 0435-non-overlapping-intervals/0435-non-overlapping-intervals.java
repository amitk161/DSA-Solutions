class Pair{
    int start;
    int end;

    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(list, (a, b) -> a.end - b.end);

        int cnt = 1, freeTime = list.get(0).end;
        for(int i=1; i<intervals.length; i++){
            if(list.get(i).start >= freeTime){
                cnt++;
                freeTime = list.get(i).end;
            }
        }
        return intervals.length - cnt;
    }
}