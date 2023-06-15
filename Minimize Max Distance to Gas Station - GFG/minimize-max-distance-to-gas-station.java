//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static double findSmallestMaxDist(int stations[],int K) {
    // code here
        int n = stations.length;
        double lo = 0;
        double hi = stations[n-1] - stations[0];
        double eps = 1e-6;
        
        double ans = -1;
        while(hi - lo > eps){
            double mid = (lo + (hi - lo) / 2);
            
            if(check(stations, mid, K)){
                ans = mid;
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return ans;
  }
  
  private static boolean check(int[] arr, double mid, int k){
      int count = 0;
      for(int i=1; i<arr.length; i++){
          int diff = arr[i] - arr[i-1];
          double val = (double) diff / mid;
          count += (int)val;
      }
      
      if(count <= k)
          return true;
      
        return false;    
  }
}
     