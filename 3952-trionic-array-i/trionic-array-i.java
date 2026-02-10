class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length <4) return false;
        int peaks = 0;
        if(nums[1]<=nums[0] || nums[nums.length-2]>=nums[nums.length-1]) return false;
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i]==nums[i-1] || nums[i]==nums[i+1]) return false;
            if((nums[i-1]<nums[i] && nums[i+1]<nums[i]) || (nums[i-1]> nums[i] && nums[i+1]>nums[i])) peaks++;
        }
        if(peaks ==2) return true;
        return false;
    }
}