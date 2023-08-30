//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }
        
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        
        while(right < s.length()){
            
            int tidx = 0;
            
            while(right < s.length()){
                if(s.charAt(right) == t.charAt(tidx)){
                    tidx++;
                }
                
                if(tidx == t.length())
                    break;
                    
                right++;
            }
        
            if(right == s.length())
                break;
                
            int left = right;
            tidx = t.length() - 1;
            
            while(left >= 0){
                if(s.charAt(left) == t.charAt(tidx)){
                    tidx--;
                }
                
                if(tidx < 0)
                    break;
                    
                left--;    
            }
            
            if(right - left + 1 < minLength){
                minLength = right - left + 1;
                ans = s.substring(left, right+1);
            }
            
            right = left + 1;
        }
        return ans;
    }
}
