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
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int k = 0;
        
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            idx = i;
        }
        
        if(max == arr[n-1])
            return k;
            
        else 
            for(int i=0; i<n; i++){
                if(arr[i] == max){
                    return i+1;
                }
            }
        return -1;    
    }
}