class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int cnt = 0;
        int res = 0;
        for(int i = cost.length-1; i>=0; i--){
            
            if(cnt == 2){
                cnt = 0;
                continue;
            }
            res += cost[i];
            cnt++;
        }
        return res;
    }

}