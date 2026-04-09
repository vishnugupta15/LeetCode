class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = (int)Math.ceil(Math.sqrt(n));

        Map<Integer,List<int[]>> smallKMap = new HashMap<>();

        for(int[] q : queries){
            int L = q[0];
            int R = q[1];
            int K = q[2];
            int V = q[3];

            if(K>=blockSize){
                for(int i = L; i<=R; i+=K){
                    nums[i] = (int)((1L*nums[i]*V)%M);
                }
            }
            else{
                smallKMap.computeIfAbsent(K,k-> new ArrayList<>()).add(q);
            }
        }

        for(Map.Entry<Integer, List<int[]>> entry: smallKMap.entrySet()){
            int K = entry.getKey();
            List<int[]> allQueries = entry.getValue();

            long[] diff = new long[n];
            Arrays.fill(diff,1);

            for(int []q: allQueries){
                int L = q[0];
                int R = q[1];
                int V = q[3];

                diff[L] = (diff[L]*V)%M;

                int steps = (R-L)/K;
                int next = L+(steps + 1)*K;

                if(next<n){
                    diff[next]= (diff[next]*power(V,M-2))%M;
                }
            }

            for(int i = 0; i<n; i++){
                if(i-K>=0){
                    diff[i] = (diff[i]*diff[i-K])%M;
                }
            }

            for(int i = 0; i<n; i++){
                nums[i]= (int)((1L*nums[i]*diff[i])%M);
            }
        }

        int result = 0;
        for(int num: nums){
            result ^= num;
        }

        return result;
    }

    int M = (int)1e9+7;

    long power(long a, long b){
        long result = 1;
        a = a%M;

        while(b>0){
            if((b&1)==1){
                result = (result*a)%M;
            }

            a = (a*a)%M;
            b>>=1;
        }
        return result;
    }
}