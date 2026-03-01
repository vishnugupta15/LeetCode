class Solution {
    public int minPartitions(String n) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder(n);
        while(sb.length()>0){
            char d = sb.charAt(sb.length()-1);
            cnt = Math.max(cnt,Integer.parseInt(Character.toString(d)));
            sb.deleteCharAt(sb.length()-1);
        }
        return cnt;
    }
}