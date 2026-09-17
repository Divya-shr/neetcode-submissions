class Solution {
    public int numSquares(int n) {

        // dp[i] = minimum number of squares needed to make i
        int[] dp = new int[n + 1];

        // We can initialize everything to a large value.
        // n is always a possible answer using 1^2:
        // n = 1 + 1 + ... + 1
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Try every perfect square <= i
            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                dp[i] = Math.min(
                    dp[i],
                    1 + dp[i - square]
                );
            }
        }

        return dp[n];
    }
}

