class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        if(n<2)return -1;
        for(int i = 0; i<n; i++){
            int cnt = 0;
            int j = i;
            int k = i;
            while(k<n){
                if(nums[k]==nums[i] && k!=i){
                    cnt++;
                    if(cnt ==1) j = k;
                    if(cnt == 2) break;
                }
                k++;
            }
            if(j==i|| k==i||k==n) continue;
            System.out.println(i+" "+j+" "+k);
            int dist = 2*(k-i);
            min = Math.min(min,dist);
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}