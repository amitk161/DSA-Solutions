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
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        int i=0, j=0, count=0;
        int n = s.length();
        int[] arr = new int[n];
        
        while(j < n){
            arr[s.charAt(j) - 'a']++;
            
            while(arr[0] != 0 && arr[1] != 0 && arr[2] != 0){
                arr[s.charAt(i) - 'a']--;
                i++;
            }
            
            count += i;
            j++;
        }
        return count;
    }
}
        
