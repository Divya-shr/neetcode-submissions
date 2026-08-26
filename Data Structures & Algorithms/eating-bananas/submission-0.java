class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find the maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {

            int k = left + (right - left) / 2;

            long hours = 0;

            // Calculate hours needed with speed k
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            if (hours <= h) {
                // k works, but maybe we can eat slower
                result = k;
                right = k - 1;
            } else {
                // k is too slow
                left = k + 1;
            }
        }

        return result;
    }
}