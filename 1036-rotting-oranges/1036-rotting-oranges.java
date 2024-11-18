class Pair{
    int first;
    int second;
    int third;

    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }

                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int tm = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int cnt = 0;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().third;
            q.remove();
            tm = Math.max(tm, time);

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && vis[nrow][ncol] != 1 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol, time+1));
                    vis[nrow][ncol] = 1;
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh)
            return -1;
        return tm;    
    }
}