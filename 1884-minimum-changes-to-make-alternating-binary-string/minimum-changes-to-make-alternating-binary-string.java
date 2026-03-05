class Solution {
    public int minOperations(String s) {
        StringBuilder zero_one = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            if(i%2==0){
                zero_one.append("0");
            }
            else{
                zero_one.append("1");
            }
        }

        int cnt = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=zero_one.charAt(i))cnt++;
        }
        return Math.min(cnt,s.length()-cnt);
    }
}