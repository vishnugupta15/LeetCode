class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for(int i = left; i<=right; i++){
            int ones = 0;
            String bs = Integer.toBinaryString(i);
            for(int j = 0; j<bs.length(); j++){
                if(bs.charAt(j)=='1') ones++;
            }

            if(isPrime(ones)==true){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean isPrime(int num){
        if(num<2) return false;
        for(int i = 2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}