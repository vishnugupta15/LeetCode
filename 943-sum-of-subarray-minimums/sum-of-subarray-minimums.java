class Solution {

    // Brute force don't work here

    // public int sumSubarrayMins(int[] arr) {
    //     int n = arr.length;
    //     int sum = 0;
    //     int mod = (int)1e9 + 7;

    //     for(int i = 0; i<n; i++){
    //         int min = arr[i];
    //         for(int j = i; j<n; j++){
    //             min = Math.min(min, arr[j]);
    //             sum = sum%mod + min;
    //         }
    //     }
    //     return sum;
    // }


    // Optimal

    public int sumSubarrayMins(int[] arr){
        int total = 0;
        
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int mod = (int)1e9+7;

        for(int i = 0; i<arr.length; i++){
            int left = i-psee[i];
            int right = nse[i]-i;

            long freq = left*right*1L;
            int val = (int)((freq*arr[i])%mod);
            total = (total + val)%mod;
        }
        return total;
    }

    private int[] findNSE(int[] arr){
        int [] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[i]<= arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        
        return ans;
    }

    private int[] findPSEE(int[] arr){
        int [] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}