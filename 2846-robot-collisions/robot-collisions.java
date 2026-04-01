class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];

        for(int i = 0; i<n; i++){
            indices[i] = i;
        }

        Stack<Integer> st = new Stack<>();

        Arrays.sort(indices,(i,j)->Integer.compare(positions[i],positions[j]));

        List<Integer> res = new ArrayList<>();

        for(int curr:indices){
            if(directions.charAt(curr)=='R'){
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && healths[curr]>0){
                    int top = st.pop();

                    if(healths[top]>healths[curr]){
                        healths[top] = healths[top]-1;
                        healths[curr] = 0;
                        st.push(top);
                    }
                    else if(healths[top]<healths[curr]){
                        healths[curr] -=1;
                        healths[top] = 0;
                    }
                    else {
                        healths[curr] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(healths[i]>0){
                res.add(healths[i]);
            }
        }
        return res;
    }
}