class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        int m = landStartTime.length;
        int n = waterStartTime.length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int finish = landStartTime[i]+landDuration[i];
                if(finish >= waterStartTime[j]) finish += waterDuration[j];
                else finish = waterStartTime[j] + waterDuration[j];

                int finish1 = waterStartTime[j] + waterDuration[j];
                if(finish1 >= landStartTime[i]) finish1 += landDuration[i];
                else finish1 = landStartTime[i] + landDuration[i];

                // System.out.println(finish + " " + finish1);
                finish = Math.min(finish,finish1);
                min = Math.min(min,finish);
            }
        }

        return min;
    }
}