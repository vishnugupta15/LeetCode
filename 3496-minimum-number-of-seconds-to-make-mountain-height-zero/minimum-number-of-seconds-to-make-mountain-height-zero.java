class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxtime = workerTimes[0];
        long result = 0;
        for(int i = 1; i<workerTimes.length; i++){
            maxtime = Math.max(maxtime, workerTimes[i]);
        }
        long l = 1;
        long r = (long)maxtime * mountainHeight * (mountainHeight+1)/2;

        while(l<=r){
            long mid = l+(r-l)/2;
            if(check(mid,mountainHeight,workerTimes)){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return result;
    }

    public boolean check(long mid, int mh, int[] workerTimes){
        long h = 0;
        for(int t : workerTimes){
            h += (long)(Math.sqrt(2.0*mid/t + 0.25)-0.5);
            if(h>=mh)return true;    
        }
        return h>=mh;
    }
}