class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result = Math.max(result, dfs(matrix, dp, r, c));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int[][] dp, int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int longest = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                matrix[nr][nc] > matrix[r][c]) {

                longest = Math.max(
                    longest,
                    1 + dfs(matrix, dp, nr, nc)
                );
            }
        }

        dp[r][c] = longest;
        return longest;
    }
}