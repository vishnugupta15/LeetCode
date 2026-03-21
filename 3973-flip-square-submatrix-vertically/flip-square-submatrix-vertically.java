class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int i = x;
        int j = x+k-1;

        while(i<j){
            for(int t=y; t<y+k; t++){
                int temp = grid[i][t];
                grid[i][t] = grid[j][t];
                grid[j][t] = temp;
            }
            i++;
            j--;
        }
        return grid;
    }
}