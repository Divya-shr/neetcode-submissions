class Solution {
    public int combinationSum4(int[] nums, int target) {

        // dp[i] = number of combinations that add up to i
        int[] dp = new int[target + 1];

        // There is exactly one way to make 0:
        // choose nothing.
        dp[0] = 1;

        // Build answers from 1 up to target
        for (int i = 1; i <= target; i++) {

            for (int num : nums) {

                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}

