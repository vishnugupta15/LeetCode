class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        Map<Character,Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),i);
            }
            else{
                if(mp.get(s.charAt(i))>=l) l = mp.get(s.charAt(i))+1;
                mp.put(s.charAt(i),i);
            }
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}