class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Integer> st = new TreeSet<>(Collections.reverseOrder());

        for(int r= 0; r<m; r++){
            for(int c = 0; c<n; c++){
                st.add(grid[r][c]);

                for(int side = 1; r-side>=0 && r+side <m && c-side>=0 && c+side <n; side++){
                    int sum = 0;
                    for(int k = 0; k<side; k++){
                        sum += grid[r-side+k][c+k];
                        sum += grid[r+k][c+side-k];
                        sum += grid[r+side-k][c-k];
                        sum += grid[r-k][c-side+k];
                    }

                    st.add(sum);
                }
                
            }
        }
        int size = Math.min(3,st.size());
        int result[] = new int[size];

        int i = 0;
        for(int val:st){
            if(i==size) break;
            result[i++] = val;
        }

        return result;
    }
}