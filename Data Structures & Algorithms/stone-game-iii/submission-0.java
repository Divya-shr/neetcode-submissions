class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        // dp[i] = maximum score difference
        // current player can achieve starting from i
        int[] dp = new int[n + 1];

        // Base case:
        // No stones left -> score difference is 0
        dp[n] = 0;

        // Use a very small value because stone values can be negative
        int NEG_INF = Integer.MIN_VALUE / 2;

        for (int i = n - 1; i >= 0; i--) {

            int sum = 0;
            dp[i] = NEG_INF;

            // Current player can take 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {

                sum += stoneValue[i + k];

                // We gain 'sum', but the opponent gets
                // dp[i + k + 1] advantage in the remaining game.
                dp[i] = Math.max(
                    dp[i],
                    sum - dp[i + k + 1]
                );
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
