//{ Driver Code Starts
// Initial Template for Java

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
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int n, int k) {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += cardPoints[i];
        }
        
        int ans = 0, window = 0;
        
        if(n == k) return sum;
        
        for(int i=0; i<n-k-1; i++){
            window += cardPoints[i];
        }
        
        for(int i=n-k-1; i<n; i++){
            window += cardPoints[i];
            ans = Math.max(ans, sum-window);
            window -= cardPoints[i-(n-k-1)];
        }
        return ans;
    }
}
