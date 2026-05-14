class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i ;
        for(i = 0; i<n;i++){
            if(nums[i]!=i+1) break;
            System.out.println(nums[i]);
        }
        return (i==n-1)&&(nums[n-1]==i)? true: false;
    }
}