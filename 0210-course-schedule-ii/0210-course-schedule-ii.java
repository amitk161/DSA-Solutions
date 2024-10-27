class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        
        int m = prerequisites.length;
        for(int i=0; i<m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[N];
        for(int i=0; i<N; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] topo = new int[N];
        int ind = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[ind++] = node;
            
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(ind == N) return topo;
        int[] res = {};
        return res;
    }
}