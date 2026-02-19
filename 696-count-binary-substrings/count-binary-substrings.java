class Solution {
    public int countBinarySubstrings(String s) {
        int one = 0;
        int zero = 0;

        if(s.charAt(0)=='0')zero++;
        else one++;

        int count = 0;

        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                count += Math.min(one,zero);
                if(s.charAt(i)=='1') one = 0;
                else zero = 0;
            }
            if(s.charAt(i)=='0') zero++;
            else one++;
        }
        count += Math.min(one,zero);
        return count;
    }
}