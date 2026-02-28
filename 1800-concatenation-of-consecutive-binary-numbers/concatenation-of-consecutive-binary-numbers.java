class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1000000007;
        int res = 0;
        for(int i = 1; i<=n; i++){
            long x = Integer.toBinaryString(i).length();
            res = (int)((((res *( Math.pow(2,x))%mod)%mod) + i)%mod);
        }
        return res;
    }
}