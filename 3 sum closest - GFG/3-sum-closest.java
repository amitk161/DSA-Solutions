//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int nums[], int n, int X)
    {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closestSum = -1;
        
        for(int i=0; i<n; i++){
            int lo = i+1, hi = n-1;
            
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if(sum < X){
                    lo++;
                    
                    int diff = Math.abs(X - sum);
                    if(diff < minDiff){
                        minDiff = diff;
                        closestSum = sum;
                    }
                } else if(sum > X){
                    hi--;
                    
                    int diff = Math.abs(X - sum);
                    if(diff < minDiff){
                        minDiff = diff;
                        closestSum = sum;
                    }
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}