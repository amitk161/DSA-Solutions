class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 1)
            return s;
        int max = 1;
        int n = s.length();
        int st = 0, end = 0;
        
        for(int i=0; i<n; i++){
            int l = i, r = i;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                } else {
                    break;
                }
            }
            int len = r-l-1;
            if(len > max){
                max = len;
                st = l+1;
                end = r-1;
            }
        }
        
        for(int i=0; i<n; i++){
            int l = i, r = i+1;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                } else {
                    break;
                }
            }
            int len = r-l-1;
            if(len > max){
                max = len;
                st = l+1;
                end = r-1;
            }
        }
        
        return s.substring(st, end+1);
    }
}