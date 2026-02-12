class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        for(int i = 0; i<n; i++){
            Map<Character,Integer> mp = new HashMap<>();
            for(int j = i; j<n; j++){
                int flag = 0;
                mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
                int temp = mp.get(s.charAt(j));
                for(char ch : mp.keySet()){
                    if (mp.get(ch)!=temp){
                        flag = 1;
                        break;
                    }
                }
                if(flag ==1) continue;    
                System.out.println(i+" "+j);
                max = Math.max(j-i+1,max);
            }
        }
        return max;
    }
}