class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int res = 0;

        int l = 0;
        int r = n-1;

        while(l<=r){
            while(l<r && nums[l]==nums[l+1]) l++;
            while(r>l && nums[r]==nums[r-1]) r--;

            int mid = (l+r)/2;
            if(nums[mid]<nums[res]) res = mid;
            if(nums[mid]>nums[r]) l = mid+1;
            else r = mid-1;
        }
        return nums[res];
    }
}