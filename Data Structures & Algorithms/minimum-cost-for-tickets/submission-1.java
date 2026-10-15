class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] travel = new boolean[366];

        for (int day : days) {
            travel[day] = true;
        }

        for (int day = 1; day <= 365; day++) {
            if (!travel[day]) {
                dp[day] = dp[day - 1];
            } else {
                dp[day] = Math.min(
                    dp[day - 1] + costs[0],
                    Math.min(
                        dp[Math.max(0, day - 7)] + costs[1],
                        dp[Math.max(0, day - 30)] + costs[2]
                    )
                );
            }
        }

        return dp[365];
    }
}