class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Odd total cannot be split into two equal subsets
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // dp[i] = whether sum i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // Go backwards so each number is used only once
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }
}