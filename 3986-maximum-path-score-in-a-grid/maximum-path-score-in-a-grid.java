class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // dp[i][j][c] = max score reaching (i,j) using c positives
        int[][][] dp = new int[m][n][k + 1];

        // initialize with very small value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = Integer.MIN_VALUE;
                }
            }
        }

        // starting point
        int startCost = grid[0][0] > 0 ? 1 : 0;
        if (startCost <= k) {
            dp[0][0][startCost] = grid[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == Integer.MIN_VALUE) continue;

                    // move right
                    if (j + 1 < n) {
                        int nc = c + (grid[i][j + 1] > 0 ? 1 : 0);
                        if (nc <= k) {
                            dp[i][j + 1][nc] = Math.max(
                                dp[i][j + 1][nc],
                                dp[i][j][c] + grid[i][j + 1]
                            );
                        }
                    }

                    // move down
                    if (i + 1 < m) {
                        int nc = c + (grid[i + 1][j] > 0 ? 1 : 0);
                        if (nc <= k) {
                            dp[i + 1][j][nc] = Math.max(
                                dp[i + 1][j][nc],
                                dp[i][j][c] + grid[i + 1][j]
                            );
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}