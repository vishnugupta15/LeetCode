class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1000000007;
        long res = 0;
        int bin = 0;
        for(int i = 1; i<=n; i++){
            if((i&(i-1))==0)bin ++;
            res = (((res << bin) + i)%mod);
        }
        return (int)res;
    }
}