//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubarray(int n, int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }
    
    private static int solve(int[] arr, int k){
        int i=0, j=0, ans=0, odd=0;
        int n = arr.length;
        
        while(j < n){
            if(arr[j] % 2 != 0){
                odd++;
            }
            
            while(odd > k){
                if(arr[i] % 2 != 0){
                    odd--;
                }
                i++;
            }
            
            ans += (j-i+1);
            j++;
        }
        
        return ans;
    }
}
        
