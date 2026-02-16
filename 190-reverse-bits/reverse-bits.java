class Solution {
    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        while(sb.length()<32){
            sb.append("0");
        }
        // System.out.println(sb.length());
        String st = sb.toString();
        return Integer.parseInt(st,2);
    }
}