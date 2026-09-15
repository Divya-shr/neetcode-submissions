class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();

        // dp[i] = minimum extra characters in s[i...n-1]
        int[] dp = new int[n + 1];

        // Base case: no characters left
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            // Option 1: s[i] is an extra character
            dp[i] = 1 + dp[i + 1];

            // Option 2: match a dictionary word starting at i
            for (String word : dictionary) {
                int len = word.length();

                if (i + len <= n &&
                    s.substring(i, i + len).equals(word)) {

                    dp[i] = Math.min(dp[i], dp[i + len]);
                }
            }
        }

        return dp[0];
    }
}

