class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int f1 = 0;
        int res = n;
        
        int i = 0;
        int j = 0;

        while(j<2*n){
            char expectedCharS1 = (j % 2 == 1) ? '1' : '0';

            if(s.charAt(j%n)!= expectedCharS1) f1++;

            if(j-i+1>n){
                expectedCharS1 = (i % 2 == 1) ? '1' : '0';
                if(s.charAt(i%n)!= expectedCharS1) f1--;
                i++;
            }
            if(j-i+1==n)
            res = Math.min(res,Math.min(f1,n-f1));
            j++;
        }
        return res;
    }
}