class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s+s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i = 0; i<2*n; i++){
            s1.append(i%2==0 ? '0' : '1');
            s2.append(i%2==0 ? '1' : '0');
        }

        int f1 = 0;
        int res = n;
        
        int i = 0;
        int j = 0;

        while(j<2*n){
            

            if(s.charAt(j)!=s1.charAt(j)) f1++;

            if(j-i+1>n){
                if(s.charAt(i)!=s1.charAt(i)) f1--;
                i++;
            }
            if(j-i+1==n)
            res = Math.min(res,Math.min(f1,n-f1));
            j++;
        }
        return res;
    }
}