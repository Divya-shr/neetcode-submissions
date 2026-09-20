class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum of piles[i...n-1]
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // dp[i][m] = maximum stones current player can get
        // starting at i with M = m
        int[][] dp = new int[n + 1][n + 1];

        // Build from the end toward the beginning
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {

                int maxX = Math.min(2 * m, n - i);

                // If we can take all remaining piles
                if (maxX == n - i) {
                    dp[i][m] = suffix[i];
                    continue;
                }

                for (int x = 1; x <= maxX; x++) {
                    int opponent = dp[i + x][Math.max(m, x)];

                    int currentPlayer =
                        suffix[i] - opponent;

                    dp[i][m] = Math.max(
                        dp[i][m],
                        currentPlayer
                    );
                }
            }
        }

        return dp[0][1];
    }
}