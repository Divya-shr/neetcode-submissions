public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] count = {a, b, c};
        StringBuilder res = new StringBuilder();

        int repeated = -1;
        while (true) {
            int maxChar = getMax(count, repeated);
            if (maxChar == -1) {
                break;
            }
            res.append((char) (maxChar + 'a'));
            count[maxChar]--;

            if (res.length() > 1 && res.charAt(res.length() - 1) == res.charAt(res.length() - 2)) {
                repeated = maxChar;
            } else {
                repeated = -1;
            }
        }

        return res.toString();
    }

    private int getMax(int[] count, int repeated) {
        int idx = -1, maxCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (i == repeated || count[i] == 0) {
                continue;
            }
            if (maxCnt < count[i]) {
                maxCnt = count[i];
                idx = i;
            }
        }
        return idx;
    }
}