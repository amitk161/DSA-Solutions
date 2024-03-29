class Solution {
    long mod = (int)1e9+7;
    
    public int countGoodNumbers(long n) {
        return (int) (pow(5, (n+1)/2) * pow(4, n/2) % mod);
    }
    
    private long pow(int x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        
        if(n % 2 == 1)
            return (x * pow(x, n-1)) % mod;
        
        long half = pow(x, n/2);
        return half * half % mod;
    }
}