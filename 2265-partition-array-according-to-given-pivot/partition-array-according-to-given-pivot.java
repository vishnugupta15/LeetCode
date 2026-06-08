class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // find pivot index first
        int n = nums.length;
        int nums1[] = new int[nums.length];

        int ind = 0;
        for(int i = 0; i<n; i++){
            if(nums[i]<pivot){
                nums1[ind] = nums[i];
                ind++;
            }
        }
        for(int i = 0; i<n; i++){
            if(nums[i]==pivot){
                nums1[ind] = nums[i];
                ind++;
            }
        }
        for(int i = 0; i<n; i++){
            if(nums[i]>pivot){
                nums1[ind] = nums[i];
                ind++;
            }
        }
        return nums1
        ;
    }
}