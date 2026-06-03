class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = findFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int water_land = findFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(land_water, water_land);
    }

    public int findFinishTime(int [] start1, int[] duration1, int[] start2, int[] duration2){
        int res1 = Integer.MAX_VALUE;
        int res2 = Integer.MAX_VALUE;

        int n = start1.length;
        int m = start2.length;

        for(int i = 0; i<n; i++){
            // sab tere hawale kar diya
            res1 = Math.min(res1, start1[i]+duration1[i]);
        }

        for(int i = 0; i<m; i++){
            res2 = Math.min(res2, Math.max(res1,start2[i])+duration2[i]);
        }
        return res2;
    }
}