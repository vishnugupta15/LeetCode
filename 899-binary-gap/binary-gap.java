class Solution {
    public int binaryGap(int n) {
        String st = Integer.toBinaryString(n);
        int max = 0;
        if(Integer.bitCount(n)<2)return 0;
        int d =0;

        for(int i = 0; i<st.length(); i++){
            if(st.charAt(i)=='1'){
                max = Math.max(d,max);
                d=0;
            }
            else d++;
        }
        return max+1;
    }
}