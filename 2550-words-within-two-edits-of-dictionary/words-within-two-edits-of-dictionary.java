class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        for(String s1:queries){
            int cnt = 0;
            for(String s2: dictionary){
                cnt = 0;
                for(int i = 0; i<s1.length(); i++){
                    if(s1.charAt(i)!=s2.charAt(i)) cnt++;
                    if(cnt>2)break;
                }
                if(cnt<3){
                    res.add(s1);
                    break;
                } 
            }
            if(cnt>2) continue;
        }
        return res;
    }
}