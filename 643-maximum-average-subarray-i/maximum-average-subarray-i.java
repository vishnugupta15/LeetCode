class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        double maxavg = Double.NEGATIVE_INFINITY;
        double sum = 0;
        for(int r = 0; r<nums.length; r++){
            sum+=nums[r];
            if(k==(r-l+1)){
                double avg = sum/k;
                maxavg = Math.max(maxavg,avg);
            }
            else if(k<(r-l+1)){
                sum=sum-nums[l];
                l++;
                double avg = sum/(double)k;
                maxavg = Math.max(maxavg,avg);
            }
        }
        return maxavg;
    }
}