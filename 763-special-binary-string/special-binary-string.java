class Solution {
    public String makeLargestSpecial(String s) {
        //  Special Binary strings are like balanced parenthesis string 
        // Assum 1 -> ( and 0 -> ) 

        if(s.length()<=2) return s;

        int cnt = 0; int start = 0;
        List<String> ls = new ArrayList<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1')
                cnt++;
            else cnt--;

            if(cnt==0){
                String inner = makeLargestSpecial(s.substring(start+1,i));
                ls.add("1"+inner+"0");
                start = i+1;
            }
        }

        Collections.sort(ls,Collections.reverseOrder());

        StringBuilder res = new StringBuilder();
        for(String str : ls ){
            res.append(str);
        }

        return res.toString();
    }
}