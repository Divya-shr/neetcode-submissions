class Solution {
    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] dp = new long[n];

        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < points.length; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] next = new long[n];

            left[0] = dp[0];

            for (int j = 1; j < n; j++) {
                left[j] = Math.max(dp[j], left[j - 1] - 1);
            }

            right[n - 1] = dp[n - 1];

            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(dp[j], right[j + 1] - 1);
            }

            for (int j = 0; j < n; j++) {
                next[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            dp = next;
        }

        long result = 0;

        for (long value : dp) {
            result = Math.max(result, value);
        }

        return result;
    }
}