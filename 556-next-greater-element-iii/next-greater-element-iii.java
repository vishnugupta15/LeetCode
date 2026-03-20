class Solution {
    public int nextGreaterElement(int n) {
        int len = (int)Math.ceil(Math.log(n)/Math.log(10));
        int num[] = new int[len];

        for(int i = len-1; i>=0; i--){
            num[i] = n%10;
            n = n/10;
        }
        int ind = -1;
        for(int i = num.length-2; i>=0; i--){
            if(num[i]<num[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            return -1;
        }
        else{
            for(int i = num.length-1; i>=0; i--){
                if(num[i]>num[ind]){
                    int temp = num[i];
                    num[i] = num[ind];
                    num[ind] = temp;
                    break;
                }
            }
            reverse(num,ind+1,num.length-1);
        }

        long res = 0;
        for(int i = 0; i<num.length; i++){
            res = res*10 + num[i];
        }

        return res>Integer.MAX_VALUE?-1:(int)res;
    }
    public void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}