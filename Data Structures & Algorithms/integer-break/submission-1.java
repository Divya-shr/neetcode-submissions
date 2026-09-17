class Solution {
    public int integerBreak(int n) {

        // dp[i] = maximum product for breaking i
        int[] dp = new int[n + 1];

        // Base case
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            // Try breaking i into:
            // j + (i - j)
            for (int j = 1; j < i; j++) {

                // Option 1:
                // Don't break the remaining part
                int product1 = j * (i - j);

                // Option 2:
                // Break the remaining part optimally
                int product2 = j * dp[i - j];

                dp[i] = Math.max(
                    dp[i],
                    Math.max(product1, product2)
                );
            }
        }

        return dp[n];
    }
}