class Solution {
    public List<String> addOperators(String num, int target) {
      List<String> ans = new ArrayList<>();
      solve(0, 0, 0, num, "", target, ans);
      return ans;  
    }

    private void solve(int ind, long prev, long sum, String num, String exp, int target, List<String> ans){
        if(ind == num.length()){
            if(sum == target)
                ans.add(exp);
            return;    
        }

        for(int i=ind; i<num.length(); i++){
            if(i != ind && num.charAt(ind) == '0')
                break;

            long curr = Long.parseLong(num.substring(ind, i+1));    

            if(ind == 0){
                solve(i+1, curr, curr, num, exp + curr, target, ans);
            } else {
                solve(i+1, curr, sum + curr, num, exp + "+" + curr, target, ans);
                solve(i+1, -curr, sum - curr, num, exp + "-" + curr, target, ans);
                solve(i+1, prev * curr, sum - prev + prev * curr, num, exp + "*" + curr, target, ans);
            }

        }
    }
}