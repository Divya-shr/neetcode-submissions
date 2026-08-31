class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i] = length of LIS ending at index i
        int[] dp = new int[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}