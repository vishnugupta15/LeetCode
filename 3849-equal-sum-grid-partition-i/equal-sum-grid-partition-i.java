class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long rowsum[] = new long[m];
        long colsum[] = new long[n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                rowsum[i] += grid[i][j];
                colsum[j] += grid[i][j];
            }
        }

        long sum1 = 0;
        for(int i = 0; i<m; i++){
            sum1+= rowsum[i];
        }

        long presum1 = 0;
        for(int i = 0; i<m; i++){
            presum1 += rowsum[i];
            sum1 -= rowsum[i];
            if(presum1 == sum1) return true;
        }

        long sum2 = 0;
        for(int i = 0; i<n; i++){
            sum2+= colsum[i];
        }

        long presum2 = 0;
        for(int i = 0; i<n; i++){
            presum2 += colsum[i];
            sum2 -= colsum[i];
            if(presum2 == sum2) return true;
        }
        return false;
    }
}