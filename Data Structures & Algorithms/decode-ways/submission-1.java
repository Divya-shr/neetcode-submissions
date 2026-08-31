class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // dp[i] = number of ways to decode first i characters
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1], assuming s.charAt(0) != '0'

        if (s.charAt(0) == '0') {
            return 0;
        }

        for (int i = 2; i <= n; i++) {
            int current = 0;

            // One-digit number: 1-9
            char one = s.charAt(i - 1);
            if (one >= '1' && one <= '9') {
                current += prev1;
            }

            // Two-digit number: 10-26
            int two = (s.charAt(i - 2) - '0') * 10
                    + (s.charAt(i - 1) - '0');

            if (two >= 10 && two <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}