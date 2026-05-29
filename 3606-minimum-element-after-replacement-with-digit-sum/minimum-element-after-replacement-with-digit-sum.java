class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i :nums){
            int sum = 0;
            while(i>0){
                int d = i%10;
                sum += d;
                i = i/10;
            }
            res = Math.min(sum,res);
        }
        return res;

    }
}