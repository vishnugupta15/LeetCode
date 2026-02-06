class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n==1)return 0;

        Arrays.sort(nums);

        int maxwin = 0;
        int l = 0;
        for(int r = 0; r<n; r++){
            while((long)nums[r]>(long)nums[l]*k){
                l++;
            }
            maxwin = Math.max(maxwin, r-l+1);
        }
        return n-maxwin;
    }
}