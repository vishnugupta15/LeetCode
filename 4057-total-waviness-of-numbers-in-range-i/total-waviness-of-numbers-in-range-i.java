class Solution {
    public int totalWaviness(int num1, int num2) {
        int wave = 0;

        for(int i = num1; i<=num2; i++){
            if(i<100) continue;
            String s = Integer.toString(i);
            for(int j = 1; j<=s.length()-2; j++){
                if((s.charAt(j)>s.charAt(j-1) && s.charAt(j)>s.charAt(j+1))||(s.charAt(j)<s.charAt(j-1) && s.charAt(j)<s.charAt(j+1))){
                    wave++;
                    System.out.println(i);
                }
            }
        }
        return wave;
    }
}