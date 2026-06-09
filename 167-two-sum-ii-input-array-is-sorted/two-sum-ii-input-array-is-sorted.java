class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int res[] = new int[2];

        for(int i = 0; i<n; i++){
            int rem = target-numbers[i];
            int ind = findrem(i+1,n,numbers,rem);
            if(ind!=-1){
                res[0]= i+1;
                res[1]= ind+1;
                return res;
            }
        }
        return res;
    }

    public int findrem(int start, int end, int [] numbers, int target){
        int i = start;
        int j = end-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(numbers[mid] == target) return mid;
            else if(numbers[mid]<target) i = mid+1;
            else j = mid-1;
        }
        return -1;
    }
}