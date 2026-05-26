class Solution {
    public int numberOfSpecialChars(String word) {
        int n  = word.length();

        Set<Character> st = new HashSet<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(word.charAt(i)-word.charAt(j)==32){
                    st.add(word.charAt(i));
                }
            }
        }
        return st.size();
    }
}