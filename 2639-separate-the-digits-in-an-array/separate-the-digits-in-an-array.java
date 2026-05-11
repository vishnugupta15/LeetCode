class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i = nums.length-1; i>=0; i--){
            int num = nums[i];
            while(num>0){
                int d = num%10;
                ls.add(d);
                num = num/10;
            }
        }

        Collections.reverse(ls);
        int[] ans = new int[ls.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}