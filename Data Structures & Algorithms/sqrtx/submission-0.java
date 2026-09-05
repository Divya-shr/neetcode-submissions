class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x;
        int result = 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid <= x) {
                result = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}