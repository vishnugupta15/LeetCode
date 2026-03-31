class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        StringBuilder st = new StringBuilder("");
        boolean canChange[] = new boolean[n+m-1];

        for(int i = 0; i<n+m-1; i++){
            st.append('$');
        }

        for(int i = 0; i<n; i++){
            char ch = str1.charAt(i);
            if(ch=='T'){
                for(int j = i; j<i+m; j++){
                    if(st.charAt(j)=='$'||str2.charAt(j-i)==st.charAt(j)){
                        st.setCharAt(j,str2.charAt(j-i));
                    }
                    else return "";
                }
            }
        }

        for(int i = 0; i<m+n-1; i++){
            if(st.charAt(i)=='$'){
                st.setCharAt(i,'a');
                canChange[i] = true;
            } 
        }

        for(int i= 0; i<n; i++){
            if(str1.charAt(i)=='F'){
                if(isSame(st,str2,i,m)){
                    boolean changed = false;

                    for(int k = i+m-1; k>=i; k--){
                        if(canChange[k]){
                            st.setCharAt(k,'b');
                            canChange[k]= false;
                            changed = true;
                            break;
                        }
                    }

                    if(!changed) return "";
                }
            }
        }
        return st.toString();
    }

    private boolean isSame(StringBuilder st, String str2, int i, int m){
        for(int j = 0; j<m; j++){
            if(st.charAt(i)!=str2.charAt(j))return false;
            i++;
        }
        return true;
    }
}