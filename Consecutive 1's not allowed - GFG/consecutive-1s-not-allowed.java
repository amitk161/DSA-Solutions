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

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        int[] ans= generateString(n);
        return (long)ans[0];
    }
    
    static int[] generateString(int n) {
    if(n == 1){
       int[] arr= new int[2];
       arr[0]= 2;
       arr[1]= 1;
       return arr;
    }
 
    int[] ans= generateString(n-1);
    int x= ans[0] % 1000000007;
    ans[0]= (ans[0]+ans[1]) % 1000000007;
    ans[1]= x;
 
    return ans;
}
}