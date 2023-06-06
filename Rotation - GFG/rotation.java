//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int lo = 0, hi = n - 1;
        int k = Integer.MAX_VALUE;
        int idx = -1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[lo] <= arr[mid]){
                if(arr[lo] < k){
                    k = arr[lo];
                    idx = lo;
                }
                lo = mid + 1;
            } else {
                if(arr[mid] < k){
                    k = arr[mid];
                    idx = mid;
                }
                hi = mid - 1;
            }
        }
        return idx;
    }
}