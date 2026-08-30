class Solution {
    public int rob(int[] nums) {
        int prev2 = 0; // Maximum from two houses back
        int prev1 = 0; // Maximum from previous house

        for (int money : nums) {
            int current = Math.max(prev1, prev2 + money);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}