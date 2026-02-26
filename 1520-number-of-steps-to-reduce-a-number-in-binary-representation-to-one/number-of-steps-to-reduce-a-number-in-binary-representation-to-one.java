class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;
        while(sb.length()>1){
            if(sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                int i = sb.length()-1;
                for(; i>=0; i--){
                    if(sb.charAt(i)=='0'){
                        sb.setCharAt(i,'1');
                        break;
                    }
                }
                if(i==-1){
                    sb.insert(0,'1');
                    for(int j = 1; j<sb.length(); j++){
                        sb.setCharAt(j,'0');
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}