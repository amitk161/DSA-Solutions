//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> addOperators(String s, int target) {
        ArrayList<String> ans = new ArrayList<>();
        solve(0, 0, 0, s, "", target, ans);
        return ans;
    }
    
    private static void solve(int ind, long prev, long sum, String s, String exp, int target, ArrayList<String> ans){
        if(ind == s.length()){
            if(sum == target){
                ans.add(exp);
            }
            return;
        }
        
        for(int i=ind; i<s.length(); i++){
            if(i != ind && s.charAt(ind) == '0')
                break;
                
            long cur = Long.parseLong(s.substring(ind, i+1));
            
            if(ind == 0){
                solve(i+1, cur, cur, s, exp + cur, target, ans);
            } else {
                solve(i+1, cur, sum + cur, s, exp + "+" + cur, target, ans);
                solve(i+1, -cur, sum - cur, s, exp + "-" + cur, target, ans);
                solve(i+1, prev * cur, sum - prev + prev * cur, s, exp + "*" + cur, target, ans);
            }
        }
    }
}
