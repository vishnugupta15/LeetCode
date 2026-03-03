class Solution {
    // public char findKthBit(int n, int k) {
    //     if(n==1 && k==1) return '0';
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 1; i<=n; i++){
    //         if(i==1){sb.append('0');continue;}
    //         StringBuilder first = new StringBuilder(sb);
    //         sb = invert(sb).reverse();
    //         sb = (first.append("1")).append(sb);
    //     }
        
    //     return sb.charAt(k-1);
    // }
    // public StringBuilder invert(StringBuilder sb){
    //     for(int i = 0; i<sb.length(); i++){
    //         if(sb.charAt(i)=='0') sb.setCharAt(i,'1');
    //         else sb.setCharAt(i,'0');
    //     }
    //     return sb;
    // }

    public char findKthBit(int n, int k){
        if(n==1) return '0';

        int len = (1<<n)-1;
        int mid = (len+1)/2;

        if(k==mid) return '1';
        if(k<mid) return findKthBit(n-1, k);

        char bit = findKthBit(n-1,len-k+1);
        return bit == '0'?'1':'0';
    }
}