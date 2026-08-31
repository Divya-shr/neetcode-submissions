class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // amount + 1 acts as infinity
        int INF = amount + 1;

        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}