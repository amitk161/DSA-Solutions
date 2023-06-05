//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int nums[], int n)
    {
        int lo = 0, hi = n - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(mid % 2 == 0 && mid + 1 < n && nums[mid] == nums[mid + 1] ||
            mid % 2 == 1 && mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            
            if(mid - 1 >= 0 && mid + 1 < n && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
        }
        return nums[lo];
    }
}