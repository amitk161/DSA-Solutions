//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        if(s.length() < 1)
            return s;
        int max = 1;
        int n = s.length();
        int st = 0, end = 0;
        
        for(int i=0; i<n; i++){
            int l = i, r = i;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                } else {
                    break;
                }
            }
            int len = r-l-1;
            if(len > max){
                max = len;
                st = l+1;
                end = r-1;
            }
        }
        
        for(int i=0; i<n; i++){
            int l = i, r = i+1;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                } else {
                    break;
                }
            }
            int len = r-l-1;
            if(len > max){
                max = len;
                st = l+1;
                end = r-1;
            }
        }
        
        return s.substring(st, end+1);
    }
}