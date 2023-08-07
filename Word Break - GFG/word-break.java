//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        if(solve(0, A, B) == 1)
            return 1;
            
        return 0;    
    }
    
    private static int solve(int ind, String A, ArrayList<String> B){
        if(ind == A.length())
            return 1;
            
        for(int i=ind; i<A.length(); i++){
            String temp = A.substring(ind, i+1);
            if(B.contains(temp) && solve(i+1, A, B) == 1)
                return 1;
        }    
        return 0;
    }
}