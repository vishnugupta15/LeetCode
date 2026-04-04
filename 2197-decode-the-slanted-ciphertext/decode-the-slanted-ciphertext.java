class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();

        int columns = l/rows;

        StringBuilder res = new StringBuilder();

        for(int col = 0; col<= columns; col++){
            for(int j = col; j<l; j+=(columns+1)){
                res.append(encodedText.charAt(j));
            }
        }

        while(res.length()>0 && res.charAt(res.length()-1)==' '){
            res.deleteCharAt(res.length()-1);
        }

        return res.toString();
    }
}