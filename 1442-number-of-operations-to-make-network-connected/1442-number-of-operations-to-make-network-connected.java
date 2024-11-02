class DisjointSet{
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();

	public DisjointSet(int n){
		for(int i=0; i<=n; i++){
			size.add(1);
			parent.add(i);
		}
	}

	public int findPar(int node){
		if(node == parent.get(node)){
			return node;
		}

		int ulp = findPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionBySize(int u, int v){
		int ulp_u = findPar(u);
		int ulp_v = findPar(v);
		if(ulp_u == ulp_v)
			return;

		if(size.get(ulp_u) < size.get(ulp_v)){
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u)); 
		}		
	}
}

class Solution {
    public int makeConnected(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtra = 0;
        int m = edge.length;
        
        for(int i=0; i<m; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            if(ds.findPar(u) == ds.findPar(v)){
                cntExtra++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        
        int cntC = 0;
        for(int i=0; i<n; i++){
            if(ds.parent.get(i) == i)
                cntC++;
        }
        
        int ans = cntC - 1;
        if(cntExtra >= ans)
            return ans;
            
        return -1;    
    }
}