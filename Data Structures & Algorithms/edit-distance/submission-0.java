class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        // word1 is empty
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int diagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int old = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = 1 + Math.min(
                        diagonal,                  // replace
                        Math.min(dp[j], dp[j - 1]) // delete, insert
                    );
                }

                diagonal = old;
            }
        }

        return dp[n];
    }
}