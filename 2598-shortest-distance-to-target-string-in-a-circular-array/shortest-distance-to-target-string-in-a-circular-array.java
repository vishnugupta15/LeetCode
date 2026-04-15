class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int min = Integer.MAX_VALUE;
        int n = words.length;
        for(int i = startIndex; i< words.length + startIndex; i++){
            int j = i%words.length;
            if(words[j].equals(target)){
                min = Math.min(Math.abs(j-startIndex),min);
                min = Math.min(Math.abs(j-n-startIndex),min);
                min = Math.min(Math.abs(j+n-startIndex),min);
                System.out.println(j);
                System.out.println(j+n);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}