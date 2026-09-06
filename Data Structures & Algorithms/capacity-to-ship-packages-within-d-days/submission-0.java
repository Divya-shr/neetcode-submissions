public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int res = 0;
        for (int weight : weights) {
            res = Math.max(res, weight);
        }
        while (true) {
            int ships = 1;
            int cap = res;
            for (int weight : weights) {
                if (cap - weight < 0) {
                    ships++;
                    cap = res;
                }
                cap -= weight;
            }
            if (ships <= days) {
                return res;
            }
            res++;
        }
    }
}