class Solution {
    public int numberOfSpecialChars(String word) {

        int n = word.length();

        int [] lastsmall = new int[26];
        int[] firstcap = new int[26];

        java.util.Arrays.fill(lastsmall, -1);
        java.util.Arrays.fill(firstcap, -1);


        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) lastsmall[ch-'a']=i;
            else if(firstcap[ch-'A']==-1) firstcap[ch-'A']=i;
        }

        int cnt = 0;
        for(int i = 0;i<26; i++){
            if(lastsmall[i]!=-1 && firstcap[i]!=-1 && firstcap[i]>lastsmall[i]){
                cnt++;
            }
        }
        return cnt;
    }
}