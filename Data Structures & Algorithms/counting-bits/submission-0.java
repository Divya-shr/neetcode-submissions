class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            output[i] = output[i & (i - 1)] + 1;
        }

        return output;
    }
}