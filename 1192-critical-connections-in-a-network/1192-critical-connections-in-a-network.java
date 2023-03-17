class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, tin, low, adj, bridges);
        return bridges;
    }
    
    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, 
                    List<List<Integer>> bridges){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            
            if(vis[it] == 0){
                dfs(it, node, vis, tin, low, adj, bridges);
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}