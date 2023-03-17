//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, st, vis, adj);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            vis[i] = 0;
            for(Integer it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
    
    private void dfs(int node, Stack<Integer> st, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it, st, vis, adj);
            }
        }
        st.push(node);
    }
    
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[node] = 1;
        
        for(Integer it: adjT.get(node)){
            if(vis[it] == 0){
                dfs3(it, vis, adjT);
            }
        }
    }
}
