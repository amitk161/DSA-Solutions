//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        int lo = -1, hi = 0;
        for(int i=0; i<N; i++){
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }
        
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            
            if(check(arr, mid, D)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private static boolean check(int[] arr, int mid, int D){
        int cnt = 1, sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(sum > mid){
                cnt++;
                sum = arr[i];
            }
        }
        
        if(cnt <= D) return true;
        return false;
    }
};