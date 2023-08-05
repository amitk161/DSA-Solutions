class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(0, 0, "", n, ans);
        return ans;
    }
    
    private void solve(int oc, int cc, String temp, int n, List<String> ans){
        if(oc == n && cc == n){
            ans.add(temp);
            return;
        }

        if(oc < n){
            solve(oc + 1, cc, temp + "(", n, ans);
        }
        
        if(cc < oc){
            solve(oc, cc + 1, temp + ")", n, ans);
        } 
    }
}