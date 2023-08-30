//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int n = s.length();
        int m = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int k=0; k<m; k++){
            map.put(p.charAt(k), map.getOrDefault(p.charAt(k), 0) + 1);
        }
        
        int i=0, j=0;
        String ans = "-1";
        int count = map.size();
        int len = Integer.MAX_VALUE;
        
        while(j < n){
            if(map.get(s.charAt(j)) != null){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            
            if(count == 0){
                while(count == 0){
                    if(len > (j-i+1)){
                        len = (j-i+1);
                        ans = s.substring(i, j+1);
                    }
                    
                    if(map.get(s.charAt(i)) != null){
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        
                        if(map.get(s.charAt(i)) > 0){
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}