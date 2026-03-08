class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int ans=nums.length;
        for(int i = 0; i<nums.length; i++){
            if(Integer.parseInt(nums[i],2)!=i){
                ans = i;
                break;
            }
        }
        StringBuilder res = new StringBuilder(Integer.toBinaryString(ans));
        while(res.length()<nums[0].length()){
            res.insert(0,'0');
        }
        return res.toString();
    }
}