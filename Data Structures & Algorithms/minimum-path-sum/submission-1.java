class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Starting cell
        dp[0][0] = grid[0][0];

        // First row
        for (int c = 1; c < n; c++) {
            dp[0][c] = grid[0][c] + dp[0][c - 1];
        }

        // First column
        for (int r = 1; r < m; r++) {
            dp[r][0] = grid[r][0] + dp[r - 1][0];
        }

        // Fill the rest
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = grid[r][c]
                         + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}