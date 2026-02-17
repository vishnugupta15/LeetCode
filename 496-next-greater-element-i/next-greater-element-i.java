class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int res[] = new int[nums1.length];
        // for(int i = 0; i<nums1.length; i++){
        //     for(int j = 0; j<nums2.length; j++){
        //         int k = 0;
        //         while(nums2[k]!=nums1[i])k++;
        //         int nextg = nums1[i];
        //         while(k<nums2.length){
        //             if(nums2[k]>nextg){
        //                 nextg = nums2[k];
        //                 res[i] = nextg;
        //                 break;
        //             }
        //             k++;
        //         }
        //         if(k==nums2.length) res[i] = -1;
        //     }
        // }
        // return res;

        Stack <Integer>st  = new Stack<>();
        int res[]= new int[nums1.length];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = nums2.length-1;i>=0; i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }
            if(!st.isEmpty()) mp.put(nums2[i],st.peek());
            else mp.put(nums2[i],-1);
            st.push(nums2[i]);
        }

        for(int i = 0; i<nums1.length; i++){
            res[i] = mp.get(nums1[i]);
        }
        return res;
    }
}