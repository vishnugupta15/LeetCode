class Solution {
    public int longestBalanced(int[] nums) {
        int maxlen = 0;
        for(int i = 0; i<nums.length; i++){
            Map<Integer,Integer> mp = new HashMap<>();
            int even = 0; int odd = 0;
            for(int j = i; j<nums.length; j++){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

                if(mp.get(nums[j])==1){
                    if(nums[j]%2==0)even++;
                    else odd++;
                }
                if(even == odd){
                    maxlen = Math.max(maxlen,j-i+1);
                } 
            }
        }
        return maxlen;
    }
}