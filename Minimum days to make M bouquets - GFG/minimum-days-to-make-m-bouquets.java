//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int m, int k, int[] bloomDay) {
       int lo = 0, hi = 0;
       int ans = -1;
       
       for(int i=0; i<bloomDay.length; i++){
           lo = Math.min(lo, bloomDay[i]);
           hi = Math.max(hi, bloomDay[i]);
       }
       
       while(lo <= hi){
           int mid = (lo + (hi - lo) / 2);
           
           if(check(bloomDay, mid, m, k)){
               ans = mid;
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
       }
       return ans;
    }
    
    private static boolean check(int[] arr, int mid, int m, int flowers){
        int count = 0, adj = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid){
                adj++;
                
                if(adj == flowers){
                    count++;
                    adj = 0;
                }
            } else {
                adj = 0;
            }
        }
        
        if(count >= m) return true;
        return false;
    }
}