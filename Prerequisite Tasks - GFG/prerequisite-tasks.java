//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V, int[][] prerequisites)
    {
        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        int n = prerequisites.length;
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0; i<V; i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            res.add(node);
            
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(res.size() == V) return true;
        return false;
    }
    
}