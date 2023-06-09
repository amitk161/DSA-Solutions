//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        int N = R * C;
        int median = N / 2;
        int lo = 1;
        int hi = 2000;
        
        while(lo <= hi){
            int mid = (lo + (hi - lo ) / 2);
            int k = findElements(matrix, mid);
            
            if(k <= median)
                lo = mid + 1;
            else if(k > median)
                hi = mid - 1;
        }
        return lo;
    }
    
    private int findElements(int[][] matrix, int assumedMid){
        int sum = 0;
        
        for(int i=0; i<matrix.length; i++){
            int lo = 0, hi = matrix[0].length - 1;
            
            while(lo <= hi){
                int mid = (lo + (hi - lo) / 2);
                
                if(matrix[i][mid] <= assumedMid)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            
            sum += lo;
        }
        return sum;
    }
}