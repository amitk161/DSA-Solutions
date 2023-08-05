//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        solve(0, 0, "", n, ans);
        return ans;
    }
    
    private void solve(int oc, int cc, String temp, int n, List<String> ans){
        if(oc == n && cc == n){
            ans.add(temp);
            return;
        }
        
        if(oc < n){
            solve(oc + 1, cc, temp + "(", n, ans);
        }
        
        if(cc < oc){
            solve(oc, cc + 1, temp + ")", n, ans);
        }
    }
}