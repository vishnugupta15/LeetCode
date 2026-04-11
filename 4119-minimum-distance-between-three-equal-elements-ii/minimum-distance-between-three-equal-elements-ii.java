class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        Map<Integer,List<Integer>> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
            if(mp.get(nums[i]).size()>=3){
                List<Integer> ls = mp.get(nums[i]);
                int size = ls.size();

                int k = ls.get(size-3);
                min = Math.min(min,2*(i-k));
            }
        }
        
        return min==Integer.MAX_VALUE? -1 : min;
    }
}