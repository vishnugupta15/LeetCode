class Solution {
    static final int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n/2 + n%2;

        return (int)((power(4,odd)*power(5,even))%mod);
    }
    public long power(long a, long b){
        if(b==0)return 1;
        long ans = power(a,b/2);
        ans%=mod;
        ans = (ans * ans)%mod;
        ans%=mod;
        if(b%2==1)ans*=a;
        ans%=mod;
        return ans;
    }

}