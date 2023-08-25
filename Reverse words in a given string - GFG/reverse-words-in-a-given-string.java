//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        int left = 0;
        int right = s.length() - 1;
        
        String temp = "";
        String ans = "";
        
        while (left <= right) {
            char ch = s.charAt(left);
            
            if (ch != '.') {
                temp += ch;
            } else if (ch == '.') {
                if (!temp.equals("")) {
                    ans = temp + (ans.isEmpty() ? "" : ".") + ans;
                    temp = "";
                }
            }
            left++;          
        }
                      
        if (!temp.equals("")) {
            ans = temp + (ans.isEmpty() ? "" : ".") + ans;
        }
        
        return ans;
    }
}