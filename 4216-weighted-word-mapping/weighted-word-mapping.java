class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";
        for(int i = 0; i<words.length; i++){
            int sum = 0;
            for(int j = 0; j<words[i].length();j++){
                sum+= weights[words[i].charAt(j)-'a'];
            }
            sum%= 26;
            sum = 26-sum;
            res+=(char)(sum+'a'-1);
            // res+=a;
        }
        return res;
    }
}