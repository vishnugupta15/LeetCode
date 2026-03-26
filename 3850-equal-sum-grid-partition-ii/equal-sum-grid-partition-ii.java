class Solution {
    long total = 0;
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                total += grid[i][j];
            }
        }

        if(check(grid)) return true;
        reverse(grid);
        if(check(grid)) return true;
        reverse(grid);

        // transpose
        int transposeGrid[][] = new int[n][m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                transposeGrid[j][i] = grid[i][j];
            }   
        }

        if(check(transposeGrid)) return true;
        reverse(transposeGrid);
        if(check(transposeGrid)) return true;

        return false;
    }

    public void reverse(int[][] grid){
        int i = 0; 
        int j = grid.length-1;

        while(i<j){
            int [] temp = grid[i];
            grid[i] = grid[j];
            grid[j] = temp;

            i++;
            j--;
        }
    }

    public boolean check(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        HashSet<Long> st = new HashSet<>();
        long top = 0;

        for(int i = 0; i<m-1; i++){
            for(int j = 0; j<n; j++){
                st.add((long)grid[i][j]);
                top += grid[i][j];
            }

            long bottom = total - top;
            long diff = top - bottom;

            if(diff==0) return true;
            if(diff == grid[0][0] || diff == grid[0][n-1] || diff == grid[i][0]) return true;
            if(i>0 && n>1 && st.contains(diff)) return true;

        } 
        return false;
    }
}