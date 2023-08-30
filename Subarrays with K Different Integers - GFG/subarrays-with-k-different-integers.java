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
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int N, int k) {
        return solve(arr, k) - solve(arr, k-1);
  }
  
  private static int solve(int[] arr, int k){
      int i=0, j=0, ans=0;
      int n = arr.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      
      while(j < n){
          map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
          
          while(map.size() > k){
              if(map.get(arr[i]) == 1){
                  map.remove(arr[i]);
              } else {
                  map.put(arr[i], map.get(arr[i]) - 1);
              }
              i++;
          }
          
          ans += (j-i+1);
          j++;
      }
      return ans;
  }
}