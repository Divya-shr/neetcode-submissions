class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[r][c] = number of ways to reach (r, c)
        int[][] dp = new int[m][n];

        // Starting cell is blocked
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // Skip the starting cell because we already initialized it
                if (r == 0 && c == 0) {
                    continue;
                }

                // Cannot travel through an obstacle
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                    continue;
                }

                // Come from above
                if (r > 0) {
                    dp[r][c] += dp[r - 1][c];
                }

                // Come from left
                if (c > 0) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
