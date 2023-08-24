//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                res += solve(freq);
            }
        }
        return res;
    }
    
    private static int solve(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<26; i++){
            if(arr[i] == 0)
                continue;
            
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return max - min;
    }
}
