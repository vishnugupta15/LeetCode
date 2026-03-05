class Solution {
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        Map<Character,Integer> freq = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }
        while(res.length()!=s.length()){
            char max = s.charAt(0);
            for (char key: freq.keySet()){
                if(freq.get(key)>freq.get(max)) max = key;
            }
            for(int i = 0; i<freq.get(max); i++){
                res.append(max);
            }
            freq.put(max,0);
        }

        return res.toString();
    }
}