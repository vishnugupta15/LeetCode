class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        Set<Integer> invalid = new HashSet<>();
        invalid.add(3);
        invalid.add(4);
        invalid.add(7);
        Set<Integer> valid = new HashSet<>();
        valid.add(2);
        valid.add(5);
        valid.add(6);
        valid.add(9);

        for(int i = 1; i<=n; i++){
            int k = Integer.toString(i).length();
            int isinvalid = 0;
            int isvalid = 0;
            int num = i;
            // System.out.println(k);
            for(int j = 0; j<k; j++){
                int d = num%10;
                // System.out.println(d);

                if(invalid.contains(d)){
                    isinvalid = 1;
                    break;
                }
                if(valid.contains(d)){
                    isvalid = 1;
                }
                num = num/10;
            }
            if(isinvalid==0 && isvalid == 1){
                // System.out.println(i);
                cnt++;
            }
        }
        return cnt;
    }
}