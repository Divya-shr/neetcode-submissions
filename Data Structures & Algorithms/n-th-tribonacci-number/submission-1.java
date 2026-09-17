class Solution {
    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int t0 = 0; // T0
        int t1 = 1; // T1
        int t2 = 1; // T2

        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2;

            // Move the window forward
            t0 = t1;
            t1 = t2;
            t2 = next;
        }

        return t2;
    }
}
