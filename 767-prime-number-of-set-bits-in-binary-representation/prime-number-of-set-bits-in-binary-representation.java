class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for(int i = left; i<=right; i++){
            int ones = Integer.bitCount(i);
            if(isPrime(ones)==true){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean isPrime(int num){
        int[] primes = {2,3,5,7,11,13,17,19};
        for(int i = 0; i<primes.length; i++){
            if(num==primes[i]) return true;
        }
        return false;
    }
}