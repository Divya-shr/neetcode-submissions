class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n];

        // Base case:
        // If there is only one pile, current player takes it.
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Build for increasing subarray length
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;

                int takeLeft = piles[l] - dp[l + 1][r];
                int takeRight = piles[r] - dp[l][r - 1];

                dp[l][r] = Math.max(takeLeft, takeRight);
            }
        }

        // Alice wins if her score is greater than Bob's.
        return dp[0][n - 1] > 0;
    }
}