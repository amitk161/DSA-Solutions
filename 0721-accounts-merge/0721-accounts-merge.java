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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> it: mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}