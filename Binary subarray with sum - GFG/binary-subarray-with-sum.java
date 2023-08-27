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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int nums[], int N, int goal){
        int ans = solve(nums, goal) - solve(nums, goal-1);
        return ans;
    }
    
    private int solve(int[] nums, int goal){
        int i=0, j=0, sum=0, count=0;
        int n = nums.length;

        while(j < n){
            sum += nums[j];

            while(sum > goal){
                sum -= nums[i];
                i++;
            }

            count += (j-i+1);
            j++;
        }
        return count;
    }
}