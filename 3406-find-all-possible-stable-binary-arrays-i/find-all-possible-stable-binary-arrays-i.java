class Solution {
    int mod  = 1_000_000_007;
    int t[][][] = new int[201][201][2];
    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int [][]a:t) for(int[] b:a) Arrays.fill(b,-1);
        int startWithOne = solve(one,zero,0,limit);
        int startWithZero = solve(one,zero,1,limit);
        return (startWithOne+startWithZero)%mod;
    }
    public int solve(int onesLeft, int zerosLeft,int lastWasOne, int limit){
        if(onesLeft==0 && zerosLeft==0){
            return 1;
        }
        if(t[onesLeft][zerosLeft][lastWasOne]!=-1){
            return t[onesLeft][zerosLeft][lastWasOne];
        }

        int result = 0;
        if(lastWasOne==1){
            for(int i = 1; i<=Math.min(limit,zerosLeft); i++){
                result = (result + solve(onesLeft,zerosLeft-i, 0,limit)) % mod;
            }
        }
        else {
            for(int i = 1; i<=Math.min(limit,onesLeft); i++){
                result = (result + solve(onesLeft-i,zerosLeft, 1,limit)) % mod;
            }
        }

        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }
}