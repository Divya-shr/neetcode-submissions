class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1;
        long bit = 1;

        while (remaining > 0) {
            // Find a zero bit in x
            if ((result & bit) == 0) {
                // Put the next bit of (n - 1) here
                if ((remaining & 1) != 0) {
                    result |= bit;
                }
                remaining >>= 1;
            }

            bit <<= 1;
        }

        return result;
    }
}