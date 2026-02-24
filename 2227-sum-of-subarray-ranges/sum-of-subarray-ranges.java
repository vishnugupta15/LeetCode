class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumOfSubarrayMins(nums);
    }

    public long sumSubarrayMaxs(int [] nums){
        int n = nums.length;
        int[] nge = findNGE(nums);
        int[] pgee = findPGEE(nums);

        long sum = 0;
        for(int i = 0; i<n; i++){
            int left = i-pgee[i];
            int right = nge[i]-i;
            long freq = 1L * right *left;
            sum += (freq * nums[i]);
        }
        return sum;
    }

    public int[] findNGE(int[] nums){
        int n = nums.length;    
        Stack<Integer> st = new Stack<>();

        int ans [] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty()?n: st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] findPGEE(int[] nums){
        int n = nums.length;    
        Stack<Integer> st = new Stack<>();

        int ans [] = new int[n];
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty()?-1: st.peek();
            st.push(i);
        }
        return ans;
    }

    public long sumOfSubarrayMins(int [] nums){
        int n = nums.length;
        int[] nse = findNSE(nums);
        int[] psee = findPSEE(nums);

        long sum = 0;
        for(int i = 0; i<n; i++){
            int left = i-psee[i];
            int right = nse[i]-i;
            long freq = 1L * right *left;
            sum += (freq * nums[i]);
        }
        return sum;
    }

    public int[] findNSE(int[] nums){
        int n = nums.length;    
        Stack<Integer> st = new Stack<>();

        int ans [] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty()?n: st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] findPSEE(int[] nums){
        int n = nums.length;    
        Stack<Integer> st = new Stack<>();

        int ans [] = new int[n];
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty()?-1: st.peek();
            st.push(i);
        }
        return ans;
    }
}