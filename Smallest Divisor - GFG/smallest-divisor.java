//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int k) {
        int lo= 1, hi = 0;
        
        for(int i=0; i<nums.length; i++){
            hi = Math.max(hi, nums[i]);
        }
        
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(check(nums, mid, k)){
                ans = mid;
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private static boolean check(int[] nums, int mid, int k){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double) nums[i] / mid);
        }
        
        if(sum <= k) return true;
        return false;
    }
}