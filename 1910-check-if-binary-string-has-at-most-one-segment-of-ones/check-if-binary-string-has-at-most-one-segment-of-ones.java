class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt=0;
        if(s.length() ==1 && s.charAt(0)=='1')return true;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                cnt++;
                while(i<s.length() && s.charAt(i)=='1')i++;
            }
        }
        if(cnt==1)return true;
        return false;
    }
}