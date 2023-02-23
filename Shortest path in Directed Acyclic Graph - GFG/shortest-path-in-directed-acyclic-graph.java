//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair
{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<N; i++){
		    adj.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		
		Stack<Integer> st = new Stack<>();
		int[] vis = new int[N];
		for(int i=0; i<N; i++){
		    if(vis[i] == 0){
		        topoSort(i, vis, adj, st);
		    }
		}
		
		int[] dis = new int[N];
		for(int i=0; i<N; i++){
		    dis[i] = (int)(1e9);
		}
		
		dis[0] = 0;
		
		while(!st.isEmpty()){
		    int node = st.peek();
		    st.pop();
		    
		    for(int i=0; i<adj.get(node).size(); i++){
		        int v = adj.get(node).get(i).first;
		        int wt = adj.get(node).get(i).second;
		        
		        if(dis[node] + wt < dis[v]){
		            dis[v] = dis[node] + wt;
		        }
		    }
		}
		
		for(int i=0; i<N; i++){
		    if(dis[i] == 1e9){
		        dis[i] = -1;
		    }
		}
		return dis;
	}
	
	private void topoSort(int node, int[] vis, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st){
	    vis[node] = 1;
	    
	    for(int i=0; i<adj.get(node).size(); i++){
	        int v = adj.get(node).get(i).first;
	        if(vis[v] == 0){
	            topoSort(v, vis, adj, st);
	        }
	    }
	    st.push(node);
	}
}