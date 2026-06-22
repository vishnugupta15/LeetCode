class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l= 0, o = 0, n = 0;
        for(char ch:text.toCharArray()){
            if(ch=='b') b+=2;
            else if(ch=='a') a+=2;
            else if(ch=='l') l++;
            else if(ch=='o') o++;
            else if(ch=='n') n+=2;
        }

        int max = Math.min(b,Math.min(a,Math.min(l,Math.min(o, n))));
        return max/2;
    }
}