//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M > N)
            return -1;
            
        int lo = A[0];
        int hi = 0;
        
        for(int i=0; i<N; i++){
            hi += A[i];
            lo = Math.min(lo, A[i]);
        }
        
        int res = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(isPossible(mid, A, M)){
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private static boolean isPossible(int barrier, int[] arr, int stu){
        int cnt = 1, sum = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] > barrier) 
                return false;
            
            if(sum + arr[i] > barrier){
                cnt++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }     
        }
        
        if(cnt > stu)
            return false;
        return true;    
    }
};