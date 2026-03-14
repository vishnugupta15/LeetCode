class Solution {
    int cnt = 0;
    String result = "";
    public String getHappyString(int n, int k) {
        solve(n, new StringBuilder(), k);
        return result;
    }

    public void solve(int n, StringBuilder curr, int k){
        if(curr.length()== n){
            cnt++;
            if(cnt ==k)result = curr.toString();
            return;
        }

        for(char c: new char[]{'a','b','c'}){
            if(curr.length()>0 && curr.charAt(curr.length()-1)==c)continue;

            //do
            curr.append(c);

            //explore
            solve(n,curr,k);

            if(!result.equals(""))return ;
            //undo
            curr.deleteCharAt(curr.length()-1);
        }
    }
}