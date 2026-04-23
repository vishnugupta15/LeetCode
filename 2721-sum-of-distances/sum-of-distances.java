class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            mp.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);
        }
        
        long[] res = new long[n];
        
        for(List<Integer> list: mp.values()){
            long totalsum = 0;
            for(int idx:list) totalsum+=idx;
            
            long leftsum = 0;
            for(int i  = 0; i<list.size(); i++){
                int idx = list.get(i);
                long rightsum = totalsum-leftsum-idx;

                long right = rightsum-(long)idx * (list.size()-i-1);
                long left = (long)idx*i- leftsum;

                res[idx] = left + right;
                leftsum += idx;
            }
        }

        return res;
    }
}