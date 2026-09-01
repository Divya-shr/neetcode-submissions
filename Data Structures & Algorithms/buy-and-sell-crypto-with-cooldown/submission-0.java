class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int hold = -prices[0];
        int sold = 0;
        int cooldown = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevCooldown = cooldown;

           
            hold = Math.max(prevHold, prevCooldown - prices[i]);

           
            sold = prevHold + prices[i];

            cooldown = Math.max(prevCooldown, prevSold);
        }

        return Math.max(sold, cooldown);
    }
}