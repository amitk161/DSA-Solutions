class Meeting {
    int start;
    int end;

    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            list.add(new Meeting(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(list, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2){
                return m1.end - m2.end;
            }
        });

        int cnt = 1, freeTime = list.get(0).end;
        for(int i=1; i<list.size(); i++){
            if(list.get(i).start >= freeTime){
                cnt++;
                freeTime = list.get(i).end;
            }
        }
        return intervals.length - cnt;
    }
}