class Solution {
    public int minimumDeletions(String s) {
        int del = 0;
        int l = 0;
        int r = s.length()-1;
        while((l<=r) && (s.charAt(l)=='a')){
            l++;
        }
        while((l<=r) && (s.charAt(r)=='b')){
            r--;
        }
        if(l>r)return 0;
        int cntb = 0;
        int deletion = 0;
        for(int i = l; i<=r; i++){
            if(s.charAt(i)=='b')cntb++;
            else{
                deletion = Math.min(deletion+1,cntb);
            }
        }
        return deletion;
    }
}