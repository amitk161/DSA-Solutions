//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        if(a.length == 0)
            return ans;
            
        String temp = "";
        for(int i=0; i<N; i++){
            temp += String.valueOf(a[i]);
        }
        
        HashMap<Character, String> map = new HashMap<>();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        solve(0, temp,  new StringBuilder(), map, ans);
        return ans;
    }
    
    private static void solve(int ind, String temp, StringBuilder sb, HashMap<Character, String> map, ArrayList<String> ans){
        if(ind == temp.length()){
            ans.add(sb.toString());
            return;
        }
        
        String curr = map.get(temp.charAt(ind));
        for(int i=0; i<curr.length(); i++){
            sb.append(curr.charAt(i));
            solve(ind+1, temp, sb, map, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


