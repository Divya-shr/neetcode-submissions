class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            // Add i - minJump into the window
            int add = i - minJump;

            if (add >= 0 && dp[add]) {
                reachableCount++;
            }

            // Remove i - maxJump - 1 from the window
            int remove = i - maxJump - 1;

            if (remove >= 0 && dp[remove]) {
                reachableCount--;
            }

            // Current index can be reached if:
            // 1. It is '0'
            // 2. There is at least one reachable index
            //    in the valid jump range
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}