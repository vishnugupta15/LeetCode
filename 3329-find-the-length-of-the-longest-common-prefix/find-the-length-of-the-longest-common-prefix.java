class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;

        Set <Integer> st = new HashSet<>();
        for(int i: arr1){
            while(i>0){
                st.add(i);
                i=i/10;
            }
        }

        for(int i: arr2){
            while(i>0){
                if(st.contains(i)) max = Math.max(max,Integer.toString(i).length());
                i=i/10;
            }
        }


        return max;
    }
}