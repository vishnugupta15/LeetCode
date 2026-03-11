class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        if((n&(n-1))==0)return n-1;
        int t = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        return (int)Math.pow(2,t)-n-1;
    }
}