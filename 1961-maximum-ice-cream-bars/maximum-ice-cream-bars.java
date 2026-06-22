class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int cnt = 0;
        for(int cost:costs){
            if(coins<cost) break;
            cnt++;
            coins-=cost;
        }
        return cnt;
    }
}