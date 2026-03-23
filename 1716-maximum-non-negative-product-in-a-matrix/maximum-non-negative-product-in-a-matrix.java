class Solution {
    long mod = 1000000007L;
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        for(int j = 1; j<n; j++){
            long val = grid[0][j];
            max[0][j] = max[0][j-1]*val;
            min[0][j] = min[0][j-1]*val;
        }

        for(int i = 1; i<m; i++){
            long val = grid[i][0];
            max[i][0] = max[i-1][0]*val;
            min[i][0] = min[i-1][0]*val;
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                long val = grid[i][j];
                long a = max[i-1][j]*val;
                long b = max[i][j-1]*val;
                long c = min[i-1][j]*val;
                long d = min[i][j-1]*val;

                max[i][j] = Math.max(Math.max(a,b),Math.max(c,d));
                min[i][j] = Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        return max[m-1][n-1]<0 ? -1 : (int)(max[m-1][n-1]%mod);
   }
}