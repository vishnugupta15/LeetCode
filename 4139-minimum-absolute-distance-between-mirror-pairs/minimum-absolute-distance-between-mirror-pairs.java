class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            mp.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);
        }
        int min  = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(mp.containsKey(reverse(nums[i]))){
                List<Integer> ls = mp.get(reverse(nums[i]));
                
                int idx = upperBound(ls,i);
                if(idx<ls.size()){
                    min = Math.min(min,ls.get(idx)-i);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1: min;
    }

    public int upperBound(List<Integer>ls, int i ){
        int l = 0, r = ls.size();
        while(l<r){
            int mid = (l+r)/2;
            if(ls.get(mid)<=i) l = mid+1;
            else r = mid;
        }
        return l;
    }
    public int reverse(int num){
        int res = 0;
        int n = num;
        while(num!=0){
            int d = num%10;
            res = res*10 + d;
            num = num/10;
        }
        return res;
    }
}