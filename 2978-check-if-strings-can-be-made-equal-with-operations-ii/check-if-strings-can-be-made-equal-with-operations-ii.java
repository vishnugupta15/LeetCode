class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        Map<Character,Integer> even = new HashMap<>();
        Map<Character,Integer> odd = new HashMap<>();

        for(int i = 0; i<n; i++){
            char ch = s1.charAt(i);
            if(i%2==0){
                even.put(ch,even.getOrDefault(ch, 0)+1);
            }
            else odd.put(ch,odd.getOrDefault(ch,0)+1);
        }

        for(int i = 0; i<n; i++){
            char ch = s2.charAt(i);
            if(i%2==0){
                if(even.containsKey(ch) && even.get(ch)!=0){
                    even.put(ch,even.get(ch)-1);
                }
                else return false;
            }
            else{
                if(odd.containsKey(ch) && odd.get(ch)!=0){
                    odd.put(ch,odd.get(ch)-1);
                }
                else return false;
            }
        }
        return true;
    }
}