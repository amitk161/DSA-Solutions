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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) continue;
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                for(int ind=0; ind<4; ind++){
                    int nrow = i + dr[ind];
                    int ncol = j + dc[ind];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                        int nodeNo = i * n + j;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        
        int mx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                for(int ind=0; ind<4; ind++){
                    int nrow = i + dr[ind];
                    int ncol = j + dc[ind];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                        set.add(ds.findPar(nrow * n + ncol));
                    }
                }
                int sizeTotal = 0;
                for(Integer it: set){
                    sizeTotal += ds.size.get(it);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        
        for(int cell=0; cell<n * n; cell++){
            mx = Math.max(mx, ds.size.get(ds.findPar(cell)));
        }
        return mx;
    }

    private boolean isValid(int nrow, int ncol, int n){
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < n;
    }
}